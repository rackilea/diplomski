public class MyBean {

   private File file;

   public void setResource(Resource resource) {
      this.file = resource.getFile();
   }
}