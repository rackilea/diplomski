BarTestOne one = new BarTestOne();
BarTestTwo two = new BarTestTwo();

Class<?> clazz1 = (Class<?>) ((ParameterizedType) one.getClass().getGenericSuperclass()).getActualTypeArguments()[0];       
Class<?> clazz2 = (Class<?>) ((ParameterizedType) ((ParameterizedType) two.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getRawType();

System.out.println(clazz1.equals(clazz2));