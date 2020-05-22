Type type = field.getGenericType();   // Get the generic type of the Field, 

if (type instanceof ParameterizedType) {
    System.out.println("Parameterized type for : " + type);

    ParameterizedType pType = (ParameterizedType) type;
    Type[] types = pType.getActualTypeArguments();

    for (Type aType: types) {
        System.out.println(aType);
    }
}