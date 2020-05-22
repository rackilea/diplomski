import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

public class StanfordLemmatizer {

    protected StanfordCoreNLP pipeline;

    public StanfordLemmatizer() {
        // Create StanfordCoreNLP object properties, with POS tagging
        // (required for lemmatization), and lemmatization
        Properties props;
        props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, lemma");

        // StanfordCoreNLP loads a lot of models, so you probably
        // only want to do this once per execution
        this.pipeline = new StanfordCoreNLP(props);
    }

    public void lemmatize(String documentText) {

        // create an empty Annotation just with the given text
        Annotation document = new Annotation(documentText);

        // run all Annotators on this text
        this.pipeline.annotate(document);

        // Iterate over all of the sentences found
        List<CoreMap> sentences = document.get(SentencesAnnotation.class);
        for (CoreMap sentence : sentences) {
            // Iterate over all tokens in a sentence
            for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
                String lemma = token.lemma();
                if (lemma != null) {
                    System.out.println("Lemma: " + lemma);
                    String originalText = token.originalText();
                    System.out.print("Token: '" + originalText + "'");
                    if (lemma.equalsIgnoreCase(originalText)) {
                        System.out.println(" is singular");
                    } else {
                        System.out.println(" is plural");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        StanfordLemmatizer lemmatizer = new StanfordLemmatizer();
        lemmatizer.lemmatize("The only creatures that are evolved enough to convey pure love are dogs and infants");
    }
}