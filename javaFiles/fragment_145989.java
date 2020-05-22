final JAXBContext jAXBContext = JAXBContext.newInstance(target);
final Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();

unmarshaller.setEventHandler(new MyValidationEventHandler());

unmarshaller.unmarshal(file);