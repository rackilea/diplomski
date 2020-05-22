package forum12323397;

import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Lists.class, Book.class);

        Lists<Book> lists = new Lists<Book>();

        Book book1 = new Book();
        book1.setTitle("A Book");
        book1.setYear(2001);
        lists.getValues().add(book1);

        Book book2 = new Book();
        book2.setTitle("Another Book");
        book2.setYear(2007);
        lists.getValues().add(book2);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(lists, System.out);
    }

}