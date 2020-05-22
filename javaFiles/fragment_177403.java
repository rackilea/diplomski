public class StackExchangeTestCase {
  protected static final Logger log = Logger.getLogger(StackExchangeTestCase.class);
  public static Show show;
  public static void setShow(Show newShow) {
    show = newShow;
  }

  @Test
  public void testJunk() throws Exception {

    Method me = (new Util.MethodNameHelper(){}).getMethod();
    Class<?> aClass = me.getDeclaringClass();
    Field att1 = aClass.getField("show");
    show = null;

    methodNameHelper.checkEnum(att1, "setShow", aClass);

    System.out.println(show); // worked
  }
}