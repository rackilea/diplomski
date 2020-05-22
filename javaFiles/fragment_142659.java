Type[] interfaces = MyConverter.class.getGenericInterfaces();

ParameterizedType interfaceType = (ParameterizedType) interfaces[0];
Type[] types = interfaceType.getActualTypeArguments();

for (Type argument : types) {
    System.out.println(argument.getTypeName());
}