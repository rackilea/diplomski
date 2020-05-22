public class JSONObject {

    //private final Map<String,Object> map; // current approach
    //you have to remove final modifier and either add a getter or make it protected. I'll choose the change modifier to protected in this case.
    protected Map<String,Object> map;

}

public class JSONObjectOrdered extends JSONObject {
    public JSONObjectOrdered(){
        this.map = new LinkedHashMap <String, Object>();
    } 
}