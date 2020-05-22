package forum11966714;

import javax.xml.bind.*;

public class Marshal {
    public static void main(String[] args) {
      Foo foo = new Foo("Adam", 34);

      try {
        JAXBContext jaxbContext = JAXBContext.newInstance(AdaptedFoo.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(new AdaptedFoo(foo), System.out);              
      } catch (JAXBException e) {
        e.printStackTrace();
      }   
    }
  }