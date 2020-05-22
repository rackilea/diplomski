package forum12512299;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Struct.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum12512299/input.xml");
        Struct struct = (Struct) unmarshaller.unmarshal(xml);

        for(String string : struct.getMembers()) {
            System.out.println(string);
        }
    }

}