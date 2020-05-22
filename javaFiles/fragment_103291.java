@JsonTypeInfo(use= JsonTypeInfo.Id.CLASS, property="_class")
@JsonSubTypes({
    @JsonSubTypes.Type(value = EventA.class),
    @JsonSubTypes.Type(value = EventB.class),
    @JsonSubTypes.Type(value = EventC.class)
}) 
public abstract class Event(){
   //code
}