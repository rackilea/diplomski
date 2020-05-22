Configuration config = new Configuration();
List<String> list = config.getComponent();
Object[] partsList = partsListRight.toArray();
for (Object object : partsList){
    list.add((String)object);
}

JAXBContext context = JAXBContext.newInstance(
                      Configuration.class.getPackage().getName());
Marshaller marshaller = context.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
marshaller.marshal(config, System.out);