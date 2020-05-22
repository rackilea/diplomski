package forum8807296;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Foo.class);

        Foo foo = new Foo();
        List<Bar> bars = new ArrayList<Bar>();
        foo.setBars(bars);

        Bar<String> stringBar = new Bar<String>();
        stringBar.setValue("string data");
        bars.add(stringBar);

        Bar<byte[]> binaryBar = new Bar<byte[]>();
        binaryBar.setValue("binary data".getBytes());
        bars.add(binaryBar);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(foo, System.out);
    }

}