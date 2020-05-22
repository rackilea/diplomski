@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Settings
{

    public static int option = 0;

    private int getOption()
    {
        return option;
    }

    @XmlElement(name = "option")
    private void setOption(int option)
    {
        Settings.option = option;
    }

    public static void main(String[] args) throws JAXBException
    {
        JAXBContext context = JAXBContext.newInstance(Settings.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(new Settings(), new File("c:\\test\\test.xml"));

        Settings.option = 5;
        System.out.println(Settings.option); // prints 5
        context.createUnmarshaller().unmarshal(new File("c:\\test\\test.xml"));
        System.out.println(Settings.option); // prints 0! :-)
    }

}