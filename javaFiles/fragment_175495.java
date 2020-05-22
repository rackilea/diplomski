import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Demo {

    public static void main(String[] args) throws Exception  {
        JAXBContext jc = JAXBContext.newInstance(IBMarketInfo.class);

        IBMarketInfo ibmi = new IBMarketInfo();
        ibmi.setTicker("FOO");
        ibmi.setTicker("BAR");

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(ibmi, System.out);
    }

}