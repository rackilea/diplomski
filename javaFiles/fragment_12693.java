import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonProgram {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        File source = new File("X:/test.json");
        Entity entity = mapper.readValue(source, Entity.class);
        ShippingProfiles shippingProfiles = entity.getShippingProfiles();
        List<Map<String, String>> profileMaps = shippingProfiles.getProfiles();

        List<Profile> profiles = new ArrayList<Profile>(profileMaps.size());
        for (Map<String, String> item : profileMaps) {
            profiles.add(mapper.convertValue(item, Profile.class));
        }
        System.out.println(profiles);
    }
}

class Entity {

    @JsonProperty("shipping_profiles")
    private ShippingProfiles shippingProfiles;

    public ShippingProfiles getShippingProfiles() {
        return shippingProfiles;
    }

    public void setShippingProfiles(ShippingProfiles shippingProfiles) {
        this.shippingProfiles = shippingProfiles;
    }
}

class ShippingProfiles {

    private List<Map<String, String>> profiles = new ArrayList<Map<String, String>>();

    @JsonAnySetter
    public void setDynamicProperty(String name, Map<String, String> map) {
        profiles.add(map);
    }

    public List<Map<String, String>> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Map<String, String>> profiles) {
        this.profiles = profiles;
    }
}

class Profile {

    private String name;
    private String value;

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

    @Override
    public String toString() {
        return "Profile [name=" + name + ", value=" + value + "]";
    }
}