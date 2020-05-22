@With(EnsureSSL.class)
class CustomerController extends Controller{
    @RequiresSSL 
    public static void sensitiveMethod1(...){
        ...
    }
    @RequiresSSL 
    public static void sensitiveMethod2(...){
        ...
    }
    public static void freeForAllToSee(...){
        ...
    }
}