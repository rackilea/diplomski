package edu.stanford.nlp.examples;

import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.sentiment.*;
import edu.stanford.nlp.util.*;
import java.util.Properties;

public class SentimentExample {

  public static void main(String[] args) {
    Annotation document = new Annotation("...insert tweet text here...");
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,sentiment");
    // you might want to enforce treating the entire tweet as one sentence
    //...if so uncomment the line below setting ssplit.eolonly to true
    // also make sure you remove newlines, this will prevent the
    // sentence splitter from dividing the tweet into different sentences
    //props.setProperty("ssplit.eolonly","true");
    props.setProperty("parse.binaryTrees","true");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    pipeline.annotate(document);
    for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class)) {
      System.out.println("---");
      System.out.println(sentence.get(CoreAnnotations.TextAnnotation.class));
      System.out.println(sentence.get(SentimentCoreAnnotations.SentimentClass.class));
    }
  }
}