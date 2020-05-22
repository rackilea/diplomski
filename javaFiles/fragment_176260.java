public class Test {

protected double WIDTH;
public double getWidTh() {
  return WIDTH;
}
public void setWidTh(double wIDTH) {
  WIDTH = wIDTH;
}
public static void main(String []args){
  Test t = new Test();
  t.setWidTh(2);
  Object c = t;
  Class klazz = c.getClass();
  try {
    for (PropertyDescriptor propertyDescriptor : Introspector
    .getBeanInfo(klazz).getPropertyDescriptors()) {
      Method m = propertyDescriptor.getReadMethod();
      if (m != null)
        System.out.println(m.invoke(c));
      }
  } catch (IllegalAccessException e) {
      e.printStackTrace();
} catch (IllegalArgumentException e) {
    e.printStackTrace();
} catch (InvocationTargetException e) {
    e.printStackTrace();
} catch (IntrospectionException e) {
    e.printStackTrace();
}
}
}