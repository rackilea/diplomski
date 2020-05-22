package com.abc.TryXmltoJava;

import java.io.File;
import javax.xml.bind.*;

public class JAXBExampleUnmarshal {

    public static void main(String[] args) {

        try {
            File file = new File("C:\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Vectors.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Vectors vectors = (Vectors) jaxbUnmarshaller.unmarshal(file);
            System.out.println(vectors);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(vectors, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}