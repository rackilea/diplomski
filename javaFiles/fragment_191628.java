package forum7851052;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Parent.class, IntegerChild.class, StringChild.class);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        IntegerChild integerChild = new IntegerChild();
        integerChild.getItem().add(1);
        integerChild.getItem().add(2);
        marshaller.marshal(integerChild, System.out);

        StringChild stringChild = new StringChild();
        stringChild.getItem().add("A");
        stringChild.getItem().add("B");
        marshaller.marshal(stringChild, System.out);
    }

}