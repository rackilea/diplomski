public class ObjectMapper extends ConfigurableMapper {

        protected void configure(MapperFactory factory) {
             factory.classMap(SourceClass.class, DestinationClass.class)
             .byDefault()
             .customize(new CustomMapper<SourceClass, DestinationClass>() {
                @Override
                public void mapAtoB(SourceClass a, DestinationClass b, MappingContext context) {
                    b.setMyField("CONSTANT_VALUE");
                }

                // ...
            })
            .register();
        }
}