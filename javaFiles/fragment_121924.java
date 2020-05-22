@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,property="type")
@JsonSubTypes({ @JsonSubTypes.Type(name = "subdocument", value = SubDocument.class),@JsonSubTypes.Type(name = "superdocument", value = SuperDocument.class) })

public class SuperDocument {

}