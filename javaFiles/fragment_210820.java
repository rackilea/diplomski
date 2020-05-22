String USER_DETAILS_XML = "./user-details.xml";
String USER_ERROR_XML = "./user-error.xml";

    public String login(String username, String password)
                throws JAXBException, PropertyException, FileNotFoundException {        
                    User user = new User();
            InvalidUser invalidUser = new InvalidUser();

            if ((username !=null && password !=null)) {
                user.setUserName(username);
                user.setFirstName("Jose");
                user.setLastName("Tom");

                JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(user, System.out);
                marshaller.marshal(user,new File(USER_DETAILS_XML));

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                User userResult = (User) jaxbUnmarshaller.unmarshal(new FileReader(
                        USER_DETAILS_XML));
                return userResult.getFirstName();
            }
            else{
                invalidUser.setCode(400);
                invalidUser.setMessage("something wrong here");
                JAXBContext jaxbContext = JAXBContext.newInstance(InvalidUser.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(invalidUser, System.out);
                marshaller.marshal(invalidUser, new File(USER_ERROR_XML));

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                InvalidUser invalidUserResult = (InvalidUser) jaxbUnmarshaller.unmarshal(new FileReader(USER_ERROR_XML));
                return invalidUserResult.getMessage();
            }
}