package com.stackoverflow.answer;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;

public class Tester {

    public static final String INPUT = "..."; // here goes your xml

    public static void main(String[] args) throws Exception {
        LibraryProfile lib = JAXB.unmarshal(new StringReader(INPUT), LibraryProfile.class);
        System.out.println(lib.getLibraryName() + " currently contains");
        System.out.println(lib.getCurrentBooks());
        System.out.println("the newest book is: " + lib.getNewBookInfo());
    }
}