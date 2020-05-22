package forum11311374;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Datas.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum11311374/input.xml");
        Datas datas = (Datas) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(datas, System.out);
    }

}