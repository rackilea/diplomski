String paragraph = "My 1st sentence. “Does it work for questions?” My third sentence.";
Reader reader = new StringReader(paragraph);
DocumentPreprocessor dp = new DocumentPreprocessor(reader);
List<String> sentenceList = new ArrayList<String>();

for (List<HasWord> sentence : dp) {
   // SentenceUtils not Sentence
   String sentenceString = SentenceUtils.listToString(sentence);
   sentenceList.add(sentenceString);
}

for (String sentence : sentenceList) {
   System.out.println(sentence);
}