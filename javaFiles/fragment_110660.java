import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestThrowaway {

public class Container {
    Response response;

    public Container() {
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}

public class Response {
    private Context Context;
    private Data Data;

    public Response() {
    }

    public TestThrowaway.Context getContext() {
        return Context;
    }

    public void setContext(TestThrowaway.Context context) {
        Context = context;
    }

    public TestThrowaway.Data getData() {
        return Data;
    }

    public void setData(TestThrowaway.Data data) {
        Data = data;
    }
}

public class Context {
    private Context Context;
    private List<TtContext> ttContext;

    public Context() {}
    public Context(Context context) {
        this.Context = context;
    }

    public TestThrowaway.Context getContext() {
        return Context;
    }

    public void setContext(TestThrowaway.Context context) {
        Context = context;
    }

    public List<TtContext> getTtContext() {
        return ttContext;
    }

    public void setTtContext(List<TtContext> ttContext) {
        this.ttContext = ttContext;
    }
}

public class TtContext {
    private String taskId;
    private String name;
    private String value;

    public TtContext(String taskId, String name, String value) {
        this.taskId = taskId;
        this.name = name;
        this.value = value;
    }

    public TtContext() {
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

public class Data {
    private Data Data;
    private List<TtData> ttData;

    public Data() {
    }

    public Data(TestThrowaway.Data data) {
        Data = data;
    }

    public TestThrowaway.Data getData() {
        return Data;
    }

    public void setData(TestThrowaway.Data data) {
        Data = data;
    }

    public void setTtData(List<TtData> ttData) {
        this.ttData = ttData;
    }

}

public class TtData {
    private String name;
    private String address;
    private String city;
    private String state;
    private Integer zipcd;

    public TtData() {
    }

    public TtData(String name, String address, String city, String state, Integer zipcd) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcd = zipcd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipcd() {
        return zipcd;
    }

    public void setZipcd(Integer zipcd) {
        this.zipcd = zipcd;
    }
}

@Test
public void test() {
    // Create inner Context object
    Context innerContext = new Context();

    // Create your ttContext list. For ease, I created a constructor that takes in all of your values
    List<TtContext> ttContexts = new ArrayList<>();
    ttContexts.add(new TtContext("", "GUID", "abc123"));

    // Add your list to your inner Context
    innerContext.setTtContext(ttContexts);

    // Create a new Context object that takes in a Context object, the inner Context object
    Context outsideContext = new Context(innerContext);

    // Create inner Data object
    Data innerData = new Data();

    // Create your ttData list.
    List<TtData> ttDatas = new ArrayList<>();
    ttDatas.add(new TtData("Bob Brown", "101 Anywhere St", "Spruce Pine", "AL", 12345));

    // Add your list to your inner Data
    innerData.setTtData(ttDatas);

    // Create a new Data object that takes in a Data object, the inner Data object
    Data outsideData = new Data(innerData);

    // Create a Response object that will set both the outsideContext object and the outsideData object
    Response response = new Response();
    response.setContext(outsideContext);
    response.setData(outsideData);

    // If you leave like this and run Gson, you won't have the wrapping "response" object.  
    // I like to create a Container object that takes in the Response object so I can create a variable 
    // called response and Gson does everything for me.  

    Container container = new Container();
    container.setResponse(response);

    // Instantiate Gson and run the method toJson.
    Gson gson = new Gson();
    String s = gson.toJson(container);
    System.out.println(s);
}
}