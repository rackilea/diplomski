public class JUnitSend extends FunctionalTestCase {

    @Override
    protected String getConfigResources() {
        return "send-xml.xml";
    }      

    public String getName() {
        return "Mule Server Test";
    }

    public Car myCar()
    {       
        Car myCar = new Car();
        myCar.setName("Ferrari");
        myCar.setColor("Red");

        return myCar;
    }

private String marshallObject(Object object)
{
   JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        StringWriter sw = new StringWriter();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(object, sw);
        return sw.toString();
}

    @Test
    public void testSendXml_car() throws Exception {        

        MuleClient client = new MuleClient(muleContext);

        MuleMessage result = client.send("http://localhost:8090/", marshallObject(myCar(), null);

        assertEquals("Hello", result.getPayloadAsString());
    }

@Test
    public void testSendXml_otherObject() throws Exception {        

        MuleClient client = new MuleClient(muleContext);

        MuleMessage result = client.send("http://localhost:8090/", marshallObject(myOtherObject(), null);

        assertEquals("Hello", result.getPayloadAsString());
    }



}