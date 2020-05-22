import java.util.*;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(UzivatelSave.class);

        List<Uzivatel> uzivatelArrayList = new ArrayList<Uzivatel>();
        uzivatelArrayList.add(new Uzivatel());
        uzivatelArrayList.add(new Uzivatel());

        UzivatelSave uzivatelSave = new UzivatelSave();
        uzivatelSave.setUzivatel(uzivatelArrayList);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(uzivatelSave, System.out);
    }

}