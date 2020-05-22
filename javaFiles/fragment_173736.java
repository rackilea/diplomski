public static void main(String[] args) throws JAXBException {

Map<String, Object> props = new HashMap<>();

InputStream importMoxyBinding = MOXyTest.class
        .getResourceAsStream("/json-binding.xml");

List<InputStream> moxyBindings = new ArrayList<>();
moxyBindings.add(importMoxyBinding);

props.put(JAXBContextProperties.OXM_METADATA_SOURCE, moxyBindings);
props.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
props.put(JAXBContextProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);

JAXBContext jc = JAXBContext.newInstance("my.package",
    CreateProjFolders.class.getClassLoader(), props);

Unmarshaller um = jc.createUnmarshaller();

InputStream json = MOXyTest.class
    .getResourceAsStream("/CreateProjFolders.json");
Source source = new StreamSource(json);

JAXBElement<CreateProjFolders> create = um.unmarshal(source, CreateProjFolders.class);
CreateProjFolders folders = create.getValue();

System.out.printf("Used JAXBContext: %s%n", jc);
System.out.printf("Unmarshalled structure: %s%n", folders);

Marshaller m = jc.createMarshaller();
m.setProperty(MarshallerProperties.INDENT_STRING, "    ");
m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
System.out.print("Marshalled structure: ");
m.marshal(folders, System.out);

}