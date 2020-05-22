public class ThingOne implements ThingOneI {

    private String data;
    private String request;

    public ThingOne() {

    }

 @Override
    public String getData() {
        return data;
    }


 @Override
    public void setData(String data) {
        this.data = data;
    }

 @Override
    public String getRequest() {
        return request;
    }

 @Override
    public void setRequest(String request) {
        this.request = request;
    }



}