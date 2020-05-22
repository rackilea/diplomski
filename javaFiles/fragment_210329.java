private static Employees unmarshalFromFile(String fileName) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    return (Employees) jaxbUnmarshaller.unmarshal(new File(fileName));
}

private static void marshalToFile(Employees data, String fileName) throws JAXBException
{
    JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    jaxbMarshaller.marshal(data, new File(fileName));
}

public static void main(String[] args) throws JAXBException {
    Employees data = unmarshalFromFile("G:/xml/employees.xml");

    Integer removeId = 1;
    data.getEmployees().removeIf((Employee emp) -> removeId.equals(emp.getId()));

    Employee newEmployee = ...
    data.getEmployees().add(newEmployee);

    marshalToFile(data, "G:/xml/employees.xml");
}