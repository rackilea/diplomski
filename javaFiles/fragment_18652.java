public class ChildConverter implements AttributeConverter<Set<Child>, String> {

ObjectMapper mapper = new ObjectMapper();

@Override
public String toGraphProperty(Set<Child> data) {
    String value = "";
    try {
        value = mapper.writeValueAsString(data);
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }
    return value;
}

@Override
public Set<Child> toEntityAttribute(String data) {
    Set<Child> mapValue = new HashSet<Child>();
    TypeReference<Set<Child>> typeRef = new TypeReference<Set<Child>>() {
    };
    try {
        mapValue = mapper.readValue(data, typeRef);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return mapValue;
}