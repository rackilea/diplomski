import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.Properties;

public class NNExample {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        String text = "So far, many different types of synchronization have been investigated, such as complete " +
                "synchronization [8], generalized synchronization [9], phase synchronization [10], " +
                "lag synchronization [11], projection synchronization [12, 13], and so forth.";
        Annotation annotation = new Annotation(text);
        pipeline.annotate(annotation);
        for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String partOfSpeechTag = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                if (partOfSpeechTag.equals("NN") || partOfSpeechTag.equals("NNS")) {
                    System.out.println(token.word());
                }
            }
        }
    }
}