Properties props = new Properties();
props.put("annotators", "tokenize");
StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

Annotation document = new Annotation(text);
pipeline.annotate(document);
for (CoreLabel token: document.get(TokensAnnotation.class)) {
    String word = token.get(TextAnnotation.class);
}