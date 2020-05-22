public class MyBean {

   public String whereToGo(String body, @Header("foo") SourceSysEnum sys) {
      ...
   }
}