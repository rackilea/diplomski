import org.json.JSONObject;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Pojo {

public String name;
public String address;
public String contactNo;


JSONObject toJsonObject(){
    return (JSONObject) JSONObject.wrap(this);
}

void convertMap(){
    Map<String,List<Pojo>> map = new HashMap<>();
    List<Pojo> list = new LinkedList<>();
    list.add(new Pojo());

    map.put("one",list);
    for(Map.Entry entry : map.entrySet()){
        for(Pojo expression : (List<Pojo>) entry.getValue()){
            JSONObject object = expression.toJsonObject();
        }
    }

}