import java.util.*;

public class CollectionTypeGuesser
{
    static Set<Class<?>> supers(Class<?> c)
    {
        if (c == null) return new HashSet<Class<?>>();

        Set<Class<?>> s = supers(c.getSuperclass());
        s.add(c);
        return s;
    }

    static Class<?> lowestCommonSuper(Class<?> a, Class<?> b)
    {
        Set<Class<?>> aSupers = supers(a);
        while (!aSupers.contains(b))
        {
            b = b.getSuperclass();
        }
        return b;
    }

    static Class<?> guessElementType(Collection<?> collection)
    {
        Class<?> guess = null;
        for (Object o : collection)
        {
            if (o != null)
            {
                if (guess == null)
                {
                    guess = o.getClass();
                }
                else if (guess != o.getClass())
                {
                    guess = lowestCommonSuper(guess, o.getClass());
                }
            }
        }
        return guess;
    }

    static class C1 { }
    static class C2 extends C1 { }
    static class C3A extends C2 { }
    static class C3B extends C2 { }

    public static void main(String[] args)
    {
        ArrayList<Integer> listOfInt = new ArrayList<Integer>();
        System.out.println(guessElementType(listOfInt)); // null
        listOfInt.add(42);
        System.out.println(guessElementType(listOfInt)); // Integer

        ArrayList<C1> listOfC1 = new ArrayList<C1>();
        listOfC1.add(new C3A());
        System.out.println(guessElementType(listOfC1)); // C3A
        listOfC1.add(new C3B());
        System.out.println(guessElementType(listOfC1)); // C2
        listOfC1.add(new C1());
        System.out.println(guessElementType(listOfC1)); // C1
    }
}