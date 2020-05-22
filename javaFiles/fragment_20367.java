package edu.stanford.nlp.examples;

import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.sentiment.*;
import edu.stanford.nlp.util.*;
import java.util.Properties;

public class AverageDocumentSentiment {

  public static void main(String[] args) {
    Annotation document =
        new Annotation("...movie review text...");
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,sentiment");
    props.setProperty("parse.binaryTrees","true");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    pipeline.annotate(document);
    int totalNegative = 0;
    int totalPositive = 0;
    int totalNeutral = 0;
    int total = 0;
    for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class)) {
      String sentenceSentiment = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
      System.out.println(sentenceSentiment);
      if (sentenceSentiment.equals("Negative")) {
        totalNegative++;
      } else if (sentenceSentiment.equals("Positive")) {
        totalPositive++;
      } else {
        totalNeutral++;
      }
      total++ ;
    }
  }
}