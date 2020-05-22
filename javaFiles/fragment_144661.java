@JsonTypeInfo(  
    use = JsonTypeInfo.Id.NAME,  
    include = JsonTypeInfo.As.PROPERTY,  
    property = "isAquatic")
@JsonSubTypes({
    @JsonSubTypes.Type(value = LandAnimal.class, name = "false"),
    @JsonSubTypes.Type(value = AquaticAnimal.class, name = "true") 
})
public abstract class Animal {
    private String isAquatic;
    ...