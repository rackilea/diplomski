public static void main(String[] args) throws JAXBException,
        FileNotFoundException {

    JAXBContext contextObj = JAXBContext.newInstance(Employee.class);

    Marshaller marshallerObj = contextObj.createMarshaller();
    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    Employee emp1 = new Employee("saman", 23, 001, 2500.00);

    marshallerObj.marshal(emp1, new FileOutputStream("employee.xml"));

}