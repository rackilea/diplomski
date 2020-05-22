Class<?> cls = A.class; // using `A` as an example
Class<?> sup = cls.getSuperclass();

 // TypeVariables of `B`
TypeVariable<?>[] tv = sup.getTypeParameters();
 // Concrete types used to extend with in `A`
Type[] actual = ((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments();

Map<TypeVariable<?>, Type> mappings // map one to the other
    = IntStream.range(0, tv.length)
        .boxed()
        .collect(Collectors.toMap(i -> tv[i], i -> actual[i]));


for(Field f : sup.getDeclaredFields()) {
    Type t1 = f.getGenericType();
    System.out.println(t1); // prints `D<T>`
    Type t2 = concretify(t1, mappings);
    System.out.println(t2); // prints `D<C>`
}