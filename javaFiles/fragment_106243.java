public class MyAction implements RequestAware {
    private Map<String,Object> request;

    public void setRequest(Map<String,Object> request){ 
        this.request = request;
    }
}