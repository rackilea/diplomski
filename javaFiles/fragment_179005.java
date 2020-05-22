import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.json.JSONException;

import java.io.IOException;
import java.util.HashMap;

public class test12 {
    public static void main(String[] args) throws IOException, JSONException {
        Object[] allUsers = get_all_users();

        String[] ignorableFieldNames = {"skip"};

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        mapper.addMixIn(Object.class, PropertyFilterMixIn.class);
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("filter properties by name",
                        SimpleBeanPropertyFilter.serializeAllExcept(
                                ignorableFieldNames));
        mapper.setFilterProvider(filters);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("users", allUsers);
        map.put("uri", "/users");
        String result = mapper.writeValueAsString(map);

        System.out.println(result);
    }

    @JsonFilter("filter properties by name")
    public static class PropertyFilterMixIn {
    }

    private static Object[] get_all_users() {
        User user1 = new User();
        user1.foo = "abc1";
        user1.bar = "def1";
        user1.skip = "this field is skipped";
        User user2 = new User();
        user2.foo = "abc2";
        user2.bar = "def2";
        user2.skip = "this field is skipped";
        return new Object[]{user1, user2};
    }

    public static class User {
        public String foo;
        public String bar;
        public String skip;
    }
}