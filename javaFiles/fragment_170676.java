public class MessageParser {

    public static Message parse(String requestStr) throws Exception {
        Unmarshaller um = JAXBContextFactory.getInstance().createUnmarshaller();
         // Does Some processing and returns the message 
        return  message;
    }

}