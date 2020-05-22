@RestController
public class JacksonCustomDesRestEndpoint {

    @RequestMapping(value = "/role", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object createRole(@RequestBody Role role) {
        return role;
    }
}

@JsonDeserialize(using = RoleDeserializer.class)
public class Role {
    // ......
}

public class RoleDeserializer extends JsonDeserializer<Role> {
    @Override
    public Role deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        // .................
        return something;
    }
}