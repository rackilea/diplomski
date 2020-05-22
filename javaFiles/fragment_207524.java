package edu.stanford.nlp.examples;

import edu.stanford.nlp.simple.*;

import java.util.*;

public class SimpleExample {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("tokenize.options", "untokenizable=allKeep");
        Document doc = new Document(props, "Joe Smith was born in California.  He moved to Chicago last year.");
        for (Sentence sent : doc.sentences()) {
            System.out.println(sent.tokens());
            System.out.println(sent.nerTags());
            System.out.println(sent.parse());
        }
    }

}