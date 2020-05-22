package com.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.namespace.QName;

public class Demo {

    public static void main(String[] args) throws Exception {
        com.home.Student studentA = new com.home.Student();
        studentA.setName("Jane Doe");
        studentA.setStatus(com.home.Status.FULL_TIME);

        JAXBContext contextA = JAXBContext.newInstance(com.home.Student.class);
        JAXBElement<com.home.Student> jaxbElementA = new JAXBElement(new QName("student"), com.home.Student.class, studentA);
        JAXBSource sourceA = new JAXBSource(contextA, jaxbElementA);

        JAXBContext contextB = JAXBContext.newInstance(com.school.Student.class);
        Unmarshaller unmarshallerB = contextB.createUnmarshaller();
        JAXBElement<com.school.Student> jaxbElementB = unmarshallerB.unmarshal(sourceA, com.school.Student.class);

        com.school.Student studentB = jaxbElementB.getValue();
        System.out.println(studentB.getName());
        System.out.println(studentB.getStatus().getCode());
    }

}