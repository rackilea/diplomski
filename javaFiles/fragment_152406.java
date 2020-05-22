class Outer{
  //Aim is to capture the type of generic type below. i.e. String
  List<String> ls = new ArrayList<String>();
}
Field field = Outer.class.getDeclaredField("ls");
ParameterizedType p = (ParameterizedType) field.getGenericType();
Class<?> claz = (Class<?>)p.getActualTypeArguments()[0];
System.out.println(claz);
// prints class java.lang.String