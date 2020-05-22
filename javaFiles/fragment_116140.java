@XStreamAlias("Objects")
public class ParentResponseObject {

    @XStreamImplicit
    List<ResponseObject> responseObjects = new ArrayList<ResponseObject>();
}

@XStreamAlias("Object")
public class ResponseObject {

    @XStreamAsAttribute
    String Type;   

    @XStreamImplicit
    List<Properties> properties = new ArrayList<Properties>();
}

@XStreamAlias("Property")
@XStreamConverter(value = ToAttributedValueConverter.class, strings = { "Value" })
public class Properties {
    String Name;
    String Type;
    String Value;
}