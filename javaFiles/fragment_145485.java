<E extends A,R extends AR<E>> List<A> getList(String fileAddr, Class<R> rClass)
{
 if(data.containsKey(fileAddr))
  return data.get(fileAddr);
 else
 {
  Constructor<R> ctor = rClass.getConstructor(String.class);
  R reader=ctor.newInstance(fileAddr);
  List<E> values=reader.getValues();
  data.put(fileAddr,values);
  return values;
 }
}