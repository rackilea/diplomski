@Bean(
    properties={    
      @Property(name="name"),
      @Property(name="phone", bound=true),
      @Property(name="friend", type=Person.class, kind=PropertyKind.LIST)
    }
)
public class Person extends PersonGen {
    // generated superclass PersonGen will contain getters/setters
    //    field definitions, property change support...
}