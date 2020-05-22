package com.turreta.jaxb.unmarshaller.listener;

import java.io.FileInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

public class DemoApp {
    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Person.class);

        XMLInputFactory xif = XMLInputFactory.newFactory();
        FileInputStream xml = new FileInputStream("src/main/resources/person.xml");
        XMLStreamReader xsr = xif.createXMLStreamReader(xml);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        PersonUnmarshallListener pul = new PersonUnmarshallListener();
        unmarshaller.setListener(pul);

        Person person = (Person) unmarshaller.unmarshal(xsr);
        System.out.println(person);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setListener(new PersonMarshallListener());
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(person, System.out);


    }
}