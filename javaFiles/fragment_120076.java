// your approach only works for this situation
class Foo implements List<String>{}
// your approach not work in these situations
class A<T> implements List<T>{}
class B extends A<Integer>{}
class C extends A<A<C>>{}

GenericUtil.getGenericTypes(Foo.class, List.class); // {String}
GenericUtil.getGenericTypes(A.class, List.class); // {T}
GenericUtil.getGenericTypes(B.class, List.class); // {Integer.class}
GenericUtil.getGenericTypes(C.class, List.class); // {A<C>}