@GET
public String getData(HttpRequest request, String dataId){
   if(!this.handleAuth(request)){
      throw new 403();
   }
   try{
      return service.getData(dataId);
   catch(Exception e){
      throw new WrappedErrorInProperHttpException(e);
   }
}