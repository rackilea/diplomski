public double example( ArrayList<CMyType> list, String type ) {
  CMyClass obj = list.get(0);
  Field field = obj.getClass().getDeclaredField(type);
  Object objOut = field.get(obj);
  // you could check for null just in case here
  double out = (Double) objOut;
  return out;
}