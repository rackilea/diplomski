SuperCar car = new SuperCar();
ParameterizedType parameterizedType = (ParameterizedType) car.getClass().getGenericSuperclass();
Type[] superClassTypes = parameterizedType.getActualTypeArguments();
for (Type type : superClassTypes) {
    System.out.println(type.getTypeName());
}