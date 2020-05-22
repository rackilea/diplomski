// remove invalid unicode characters
String tmpDoc1 = document.replaceAll("[^\\u0009\\u000a\\u000d\\u0020-\\uD7FF\\uE000-\\uFFFD]", "");
// remove other unicode characters coreNLP can't handle
String tmpDoc2 = tmpDoc1.replaceAll("[\\uD83D\\uFFFD\\uFE0F\\u203C\\u3010\\u3011\\u300A\\u166D\\u200C\\u202A\\u202C\\u2049\\u20E3\\u300B\\u300C\\u3030\\u065F\\u0099\\u0F3A\\u0F3B\\uF610\\uFFFC]", "");
DocumentPreprocessor tokenizer = new DocumentPreprocessor(new StringReader(tmpDoc2));
for (List<HasWord> sentence : tokenizer) {
    List<TaggedWord> tagged = tagger.tagSentence(sentence);
    GrammaticalStructure gs = parser.predict(tagged);
    System.err.println(gs);
}