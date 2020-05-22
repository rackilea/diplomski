class EnsureSSL extends Controller {
    @Before 
    static void verifySSL() { 
        if((!request.secure) 
            && (request.invokedMethod.getAnnotation(RequiresSSL.class) != null)) { 
        redirect("https://" + request.host + request.url); 
        } 
    } 
}