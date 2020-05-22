@StepScope
@Bean(name="xmlReader")
public SynchronizedItemStreamReader<StudentDTO> reader() 
{
    StaxEventItemReader<StudentDTO> xmlFileReader = new StaxEventItemReader<>();
    xmlFileReader.setResource(new ClassPathResource("students.xml"));
    xmlFileReader.setFragmentRootElementName("student");

    Map<String, Class<?>> aliases = new HashMap<>();
    aliases.put("student", StudentDTO.class);

    XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
    xStreamMarshaller.setAliases(aliases);

    xmlFileReader.setUnmarshaller(xStreamMarshaller);

    SynchronizedItemStreamReader< StudentDTO> synchronizedItemStreamReader = new SynchronizedItemStreamReader<>();
    synchronizedItemStreamReader.setDelegate(xmlFileReader);
    return synchronizedItemStreamReader;
}