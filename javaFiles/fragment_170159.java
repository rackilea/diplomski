package mypackage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import flexjson.JSONSerializer;


public class JsonArrayGenerator {
    private String id;

    public JsonArrayGenerator(String id) {
        super();
        this.id = id;
    }

    public String getJsonArray(){
        //some list of things
        List<Object> list = new ArrayList<Object>();
        list.add(1);
        list.add(this.id);
        list.add(new Date());
        list.add("Hello");

        //now serialize
        JSONSerializer serializer = new JSONSerializer();
        String json = serializer.serialize(list);

        return json;
    }
}