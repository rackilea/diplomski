Class c0 = MyString.class;
Class c1 = MyDouble.class;

ParameterizedType c0Type = (ParameterizedType) c0.getGenericInterfaces()[0];
Class<?> type0Class = (Class<?>) c0Type.getActualTypeArguments()[0];

ParameterizedType c1Type = (ParameterizedType) c1.getGenericInterfaces()[0];
Class<?> type1Class = (Class<?>) c1Type.getActualTypeArguments()[0];

System.out.println(type0Class.isAssignableFrom(String.class));  // true
System.out.println(type1Class.isAssignableFrom(String.class));  // false