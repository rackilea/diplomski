public class InsertStuff {

    @Action(interceptorRefs={
        @InterceptorRef("BlockGetRequestsInterceptor"), 
        @InterceptorRef("defaultStack")})
    public String execute(){
        getService().insertStuff(stuff);
        return SUCCESS;
    }

    // ...