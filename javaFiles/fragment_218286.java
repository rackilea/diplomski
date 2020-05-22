Properties props = new Properties();

props.setProperty("annotators","tokenize, ssplit, pos");

StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
Annotation annotation = new Annotation("I'm so happy about my marks");
pipeline.annotate(annotation);
List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
for (CoreMap sentence : sentences) {
    for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
        String word = token.get(CoreAnnotations.TextAnnotation.class);
        // this is the POS tag of the token
        String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
        System.out.println(word + "/" + pos);
    }
}