package mcve;

import java.util.*;
import java.lang.reflect.*;

class TypeTest {
    class Employee {}
    abstract class Foo<F>    implements Set<F> {}
    abstract class Bar<A, B> extends    Foo<B> {}
    Set<Employee> getSet() { return Collections.emptySet(); }

    public static void main(String[] args) throws ReflectiveOperationException {
        Method m = TypeTest.class.getDeclaredMethod("getSet");
        Type   r = m.getGenericReturnType();
        if (r instanceof ParameterizedType) {
            boolean isAssignable;
            isAssignable =
            //  Testing i.e. Set<Employee> assignable from HashSet<Employee>
                isNaivelyAssignable((ParameterizedType) r,
                                    HashSet.class,
                                    Employee.class);
            System.out.println(isAssignable);
            isAssignable =
            //  Testing i.e. Set<Employee> assignable from Bar<String, Employee>
                isNaivelyAssignable((ParameterizedType) r,
                                    Bar.class,
                                    String.class,
                                    Employee.class);
            System.out.println(isAssignable);
        }
    }

    static boolean isNaivelyAssignable(ParameterizedType sType,
                                       Class<?>          tRawType,
                                       Class<?>...       tArgs) {
        Class<?> sRawType = (Class<?>) sType.getRawType();
        Type[]   sArgs    = sType.getActualTypeArguments();
        // Take the easy way out, if possible.
        if (!sRawType.isAssignableFrom(tRawType)) {
            return false;
        }
        // Take the easy way out, if possible.
        if (sRawType.equals(tRawType)) {
            return Arrays.equals(sArgs, tArgs);
        }

        Deque<ParameterizedType> tHierarchyToS = new ArrayDeque<>();
        // Find the generic superclass of T whose raw type is the
        // same as S. For example, suppose we have the following
        // hierarchy and method:
        //  abstract class Foo<F>    implements Set<F> {}
        //  abstract class Bar<A, B> extends    Foo<B> {}
        //  class TypeTest { Set<Employee> getSet() {...} }
        // The we invoke isNaivelyAssignable as follows:
        //  Method m = TypeTest.class.getDeclaredMethod("getSet");
        //  Type   r = m.getGenericReturnType();
        //  if (t instanceof ParameterizedType) {
        //      boolean isAssignable =
        //          isNaivelyAssignable((ParameterizedType) r,
        //                              Bar.class,
        //                              String.class,
        //                              Employee.class);
        //  }
        // Clearly the method ought to return true because a
        // Bar<String, Employee> is a Set<Employee>.
        // To get there, first find the superclass of T
        // (T is Bar<String, Employee>) whose raw type is the
        // same as the raw type of S (S is Set<Employee>).
        // So we want to find Set<F> from the implements clause
        // in Foo.
        Type tParameterizedS = findGenericSuper(sRawType, tRawType, tHierarchyToS);
        if (tParameterizedS == null) {
            // Somebody inherited from a raw type or something.
            return false;
        }
        // Once we have Set<F>, we want to get the actual type
        // arguments to Set<F>, which is just F in this case.
        Type[] tArgsToSuper = tHierarchyToS.pop().getActualTypeArguments();
        if (tArgsToSuper.length != sArgs.length) {
            return false; // or throw IllegalArgumentException
        }
        // Then for each type argument to e.g. Set in the generic
        // superclass of T, we want to map that type argument to
        // one of tArgs. In the previous example, Set<F> should map
        // to Set<Employee> because Employee.class is what we passed
        // as the virtual type argument B in Bar<A, B> and B is what
        // is eventually provided as a type argument to Set.
        for (int i = 0; i < tArgsToSuper.length; ++i) {
            // tArgToSuper_i is the type variable F
            Type tArgToSuper_i = tArgsToSuper[i];

            if (tArgToSuper_i instanceof TypeVariable<?>) {
                // Copy the stack.
                Deque<ParameterizedType> tSupers = new ArrayDeque<>(tHierarchyToS);
                do {
                    TypeVariable<?> tVar_i = (TypeVariable<?>) tArgToSuper_i;
                    // The type variable F was declared on Foo so vDecl is
                    // Foo.class.
                    GenericDeclaration vDecl = tVar_i.getGenericDeclaration();
                    // Find the index of the type variable on its declaration,
                    // because we will use that index to look at the actual
                    // type arguments provided in the hierarchy. For example,
                    // the type argument F in Set<F> is at index 0 in Foo<F>.
                    // The type argument B to Foo<B> is at index 1 in Bar<A, B>.
                    TypeVariable<?>[] declVars = vDecl.getTypeParameters();
                    int tVarIndex = Arrays.asList(declVars).indexOf(tVar_i);
                    // Eventually we will walk backwards until we actually hit
                    // the class we passed in to the method, Bar.class, and are
                    // able to map the type variable on to one of the type
                    // arguments we passed in.
                    if (vDecl.equals(tRawType)) {
                        tArgToSuper_i = tArgs[tVarIndex];
                    } else {
                        // Otherwise we have to start backtracking through
                        // the stack until we hit the class where this type
                        // variable is declared. (It should just be the first
                        // pop(), but it could be the type variable is declared
                        // on e.g. a method or something, in which case we
                        // will empty the stack looking for it and eventually
                        // break from the loop and return false.)
                        while (!tSupers.isEmpty()) {
                            ParameterizedType tSuper    = tSupers.pop();
                            Class<?>          tRawSuper = (Class<?>) tSuper.getRawType();
                            if (vDecl.equals(tRawSuper)) {
                                tArgToSuper_i = tSuper.getActualTypeArguments()[tVarIndex];
                                break;
                            }
                        }
                    }
                } while (tArgToSuper_i instanceof TypeVariable<?>);
            }

            if (!tArgToSuper_i.equals(sArgs[i])) {
                return false;
            }
        }

        return true;
    }

    // If we have a raw type S which is Set from e.g. the parameterized
    // type Set<Employee> and a raw type T which is HashSet from e.g.
    // the parameterized type HashSet<Employee> we want to find the
    // generic superclass of HashSet which is the same as S, pushing
    // each class in between on to the stack for later. Basically
    // just walk upwards pushing each superclass until we hit Set.
    // For e.g. s = Set.class and t = HashSet.class, then:
    //  tHierarchyToS = [Set<E>, AbstractSet<E>].
    // For e.g. s = Set.class and t = Bar.class, then:
    //  tHierarchyToS = [Set<F>, Foo<B>]
    static ParameterizedType findGenericSuper(Class<?> s,
                                              Class<?> t,
                                              Deque<ParameterizedType> tHierarchyToS) {
        ParameterizedType tGenericSuper = null;

        do {
            List<Type> directSupertypes = new ArrayList<>();
            directSupertypes.add(t.getGenericSuperclass());
            Collections.addAll(directSupertypes, t.getGenericInterfaces());

            for (Type directSuper : directSupertypes) {
                if (directSuper instanceof ParameterizedType) {
                    ParameterizedType pDirectSuper = (ParameterizedType) directSuper;
                    Class<?>          pRawSuper    = (Class<?>) pDirectSuper.getRawType();

                    if (s.isAssignableFrom(pRawSuper)) {
                        tGenericSuper = pDirectSuper;
                        t             = pRawSuper;
                        tHierarchyToS.push(tGenericSuper);
                        break;
                    }
                }
            }
        } while (!s.equals(t) && tGenericSuper != null);

        return tGenericSuper;
    }
}