public class ResourceAwareString implements ResourceAware {
     private String content;
     private Resource res;

     @Override
     public void setResource(Resource res) {
         this.res = res;
     }
}