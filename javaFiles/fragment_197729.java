@Bean
public ItemReader<Object> reader(){
    StaxEventItemReader<Object> reader = new StaxEventItemReader<Object>();
    reader.setResource( new ClassPathResource("input.xml") );
    reader.setFragmentRootElementName("parent");

    Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
    unmarshaller.setClassesToBeBound( Parent.class, Child.class );

    reader.setUnmarshaller( unmarshaller );
    return reader;
}