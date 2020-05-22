import java.lang.reflect.Method;

public class Index {
  static final MethodDescription DESC_ACCESSOR;
  static {
    MethodDescription md;
    try {
      Method.class.getMethod("getParameters");// test JRE feature
      // instantiate specialized solution
      md=(MethodDescription) Class.forName("MethodDescriptionJ8").newInstance();
    } catch(ReflectiveOperationException|LinkageError ex) {
      md=new MethodDescription(); // J7 fall-back
    }
    DESC_ACCESSOR=md;
  }

  void tellme(String yourname) {
      /* ... */
  }

  public static void main(String[] args) throws Exception {
      Method tellme = Index.class.getDeclaredMethod("tellme", String.class);
      String desc=DESC_ACCESSOR.get(tellme);
      System.out.println(desc);
  }
}
class MethodDescription {// base class defining application specific feature
    public String get(Method tellme) {// and providing fall-back implementation
      return String.format("(java7) %s %s(%s %s){/*...*/}",
          tellme.getReturnType(),
          tellme.getName(),
          tellme.getParameterTypes()[0].getName(),
          "arg0");
    }
}