package jello.common;

import java.util.List;

import com.google.gson.Gson;
import java.util.AbstractMap;

public class JsonHelper {

    private Object json;

    public JsonHelper(String jsonString) {
        Gson g = new Gson();
        json = g.fromJson(jsonString, Object.class);
    }

    public static JsonHelper forString(String jsonString) {
        return new JsonHelper(jsonString);
    }

    @SuppressWarnings("unchecked")
    public Object getValue(String path) {
        Object value = json;
        String [] elements = path.split("\\.");
        for(String element : elements) {
            String ename = element.split("\\[")[0];

            if(AbstractMap.class.isAssignableFrom(value.getClass())) {
                value = ( (AbstractMap<String, Object>) value).get(ename);

                if(element.contains("[")) {
                    if(List.class.isAssignableFrom(value.getClass())) {
                        Integer index = Integer.valueOf(element.substring(element.indexOf("[")+1, element.indexOf("]")) );
                        value = ((List<Object>) value).get(index);
                    }
                    else {
                        return null;
                    }
                }
            }
            else {
                return null;
            }
        }

        return value;
    }
}