package edu.stanford.nlp.examples;

import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.semgraph.*;
import edu.stanford.nlp.util.*;

import java.util.*;

public class PrintParse {

  public static void main(String[] args) {
    Annotation document =
        new Annotation("My dog also likes eating sausage.");
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    pipeline.annotate(document);
    for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class)) {
      Tree constituencyParse = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
      System.out.println(constituencyParse);
      SemanticGraph dependencyParse =
          sentence.get(SemanticGraphCoreAnnotations.BasicDependenciesAnnotation.class);
      System.out.println(dependencyParse.toList());
    }
  }

}