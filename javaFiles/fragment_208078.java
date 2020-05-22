package edu.stanford.nlp.examples;

import edu.stanford.nlp.pipeline.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;


public class MultiThreadStringExample {

    public static class AnnotationCollector<T> implements Consumer<T> {

        List<T> annotations = new ArrayList<T>();

        public void accept(T ann) {
            annotations.add(ann);
        }
    }

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,depparse");
        props.setProperty("threads", "4");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        AnnotationCollector<Annotation> annCollector = new AnnotationCollector<Annotation>();
        List<String> exampleStrings = new ArrayList<String>();
        for (String exampleString : exampleStrings) {
            pipeline.annotate(new Annotation(exampleString), annCollector);
        }
        Thread.sleep(10000);
        List<CoreDocument> coreDocs =
                annCollector.annotations.stream().map(ann -> new CoreDocument(ann)).collect(Collectors.toList());
        for (CoreDocument coreDoc : coreDocs) {
            System.out.println(coreDoc.tokens());
        }
    }

}