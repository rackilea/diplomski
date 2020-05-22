package edu.stanford.nlp.examples;

import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.util.*;

import java.util.*;

public class PipelineExample {

  public static void main(String[] args) {
    // set up pipeline properties
    Properties props = StringUtils.argsToProperties("-props", "StanfordCoreNLP-chinese.properties");
    props.setProperty("annotators", "tokenize,ssplit");
    // set up Stanford CoreNLP pipeline
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    // build annotation for a review
    Annotation annotation = new Annotation("...Chinese text to segment...");
    // annotate the review
    pipeline.annotate(annotation);
    for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
      for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
        System.out.println(token);
      }
    }
  }
}