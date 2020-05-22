@JsonCreator
public static RequestType create(String value) {
    if(value == null) {
        return null;
    }
    for(RequestType v : values()) {
        if(value.equals(v.getName())) {
            return v;
        }
    }
    return null;
}