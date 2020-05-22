public void addElement(Collection<T> c, Class<? extends T> clz) 
  throws Exception
{
  Constructor<? extends T> ctor = clz.getConstructor();
  T el = ctor.newInstance();
  c.add(el);
}