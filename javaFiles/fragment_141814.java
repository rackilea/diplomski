import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.type.CollectionLikeType;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("path to json").getAbsoluteFile();


        ObjectMapper mapper = new ObjectMapper();
        UsersResponse data = mapper.readValue(jsonFile, UsersResponse.class);
        System.out.println(data);
        CollectionLikeType usersListType = mapper.getTypeFactory().constructCollectionLikeType(List.class, User.class);
        List<User> users = mapper.convertValue(data.getUsers().values(), usersListType);
        System.out.println(users);
    }
}