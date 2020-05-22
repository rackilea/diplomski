public static void main(String... args) throws Exception {
    DepartmentBean departmentBean = read();
    UserBean user = new UserBean();
    user.setPassword("pass");
    user.setUsername("user2");

    departmentBean.addIfAbsent(user);
    write(departmentBean);
}

public static DepartmentBean read() throws JAXBException {
    JAXBContext context = JAXBContext.newInstance(DepartmentBean.class, UserBean.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    return (DepartmentBean) unmarshaller.unmarshal(new StreamSource(new File("1.xml")));
}

public static void write(DepartmentBean department) throws JAXBException {
    JAXBContext context = JAXBContext.newInstance(DepartmentBean.class, UserBean.class);
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    marshaller.marshal(department, new File("1.xml"));
}