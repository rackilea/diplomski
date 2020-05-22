//in Docket
.pathProvider(new ParticularVersionPathProvider("v1"))

...
class ParticularVersionPathProvider extends AbstractPathProvider {
   ...
   private String version;
   BasePathAwareRelativePathProvider(String version){
       this.version = version;
   }

   @Override
   public String getOperationPath(String operationPath) {
       //very schematically
       return operationPath.replace("v{version}",version);
   }
}