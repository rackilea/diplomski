import java.io.File;
import javax.xml.bind.*;

public class Example {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Demo.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xsr = new File("src/forum16684040/input.xml");
        Demo demo = (Demo) unmarshaller.unmarshal(xsr);

        System.out.println(demo);
    }

}