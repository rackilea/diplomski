Properties props = new Properties();
props.setProperty("annotators", "tokenize, ssplit, pos, parse, sentiment");
StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

// read some text in the text variable
String text = ... // Add your text here!

// create an empty Annotation just with the given text
Annotation document = new Annotation(text);

// run all Annotators on this text
pipeline.annotate(document);

// these are all the sentences in this document
// a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
List<CoreMap> sentences = document.get(SentencesAnnotation.class);

for (CoreMap sentence : sentences) {
  String sentimentLabel = sentence.get(SentimentCoreAnnotations.ClassName.class);

  // ...
}