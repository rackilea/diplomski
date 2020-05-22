@JsonTypeInfo(
   use = JsonTypeInfo.Id.NAME, 
   include = JsonTypeInfo.As.PROPERTY, 
   property = "type")
@JsonSubTypes({ 
   @Type(value = Person.class, name = "Person"), 
   @Type(value = Role.class, name = "Role") 
   // ...
 })
 public abstract class Individual {
    // ...
 }