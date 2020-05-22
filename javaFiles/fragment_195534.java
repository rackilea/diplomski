package edu.stanford.nlp.examples;

import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.util.*;

import java.util.*;

public class EntityMentionsExample {

  public static void main(String[] args) {
    Annotation document =
        new Annotation("John Smith visited Los Angeles on Tuesday. He left Los Angeles on Wednesday.");
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,entitymentions");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    pipeline.annotate(document);

    for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class)) {
      for (CoreMap entityMention : sentence.get(CoreAnnotations.MentionsAnnotation.class)) {
        System.out.println(entityMention);
        System.out.println(entityMention.get(CoreAnnotations.EntityTypeAnnotation.class));
      }
    }
  }
}