Annotation document = new Annotation(text);
Properties props = new Properties();
props.setProperty("annotators", "tokenize, ssplit, pos, lemma, parse");
props.setProperty("ssplit.newlineIsSentenceBreak", "always");
props.setProperty("ssplit.eolonly", "true");
props.setProperty("pos.model", modelPath1);
props.setProperty("parse.model", modelPath);
props.setProperty("parse.keepPunct", "true");

StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

pipeline.annotate(document);

for (CoreMap sentence : sentences) {
   //Pick whichever representation you want
   SemanticGraph basicDeps = sentence.get(SemanticGraphCoreAnnotations.BasicDependenciesAnnotation.class);
   SemanticGraph collapsed = sentence.get(SemanticGraphCoreAnnotations.CollapsedDependenciesAnnotation.class);
   SemanticGraph ccProcessed = sentence.get(SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation.class);
}