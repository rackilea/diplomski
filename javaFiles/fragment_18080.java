public class Model_ApiCaller {
    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    private String apiName;
    public Model_ApiCaller( String apiName){
        this.apiName = apiName;
    }

    public Model_ApiCaller(){

    }
}


public class ModelApiResponse {
    private String types, Api;

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getApi() {
        return Api;
    }

    public void setApi(String api) {
        Api = api;
    }
}