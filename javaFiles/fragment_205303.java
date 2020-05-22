package forum14193944;

import java.io.*;
import javax.xml.bind.*;
import com.sun.xml.bind.marshaller.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum14193944/input.xml");
        Root root = (Root) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(CharacterEscapeHandler.class.getName(),
                new CharacterEscapeHandler() {
                    @Override
                    public void escape(char[] ac, int i, int j, boolean flag,
                            Writer writer) throws IOException {
                        writer.write(ac, i, j);
                    }
                });
        marshaller.marshal(root, new OutputStreamWriter(System.out));
    }

}