StringToWordVector() filter = new StringToWordVector();    
filter.setWordsToKeep(1000000);
if(useIdf){
    filter.setIDFTransform(true);
}
filter.setTFTransform(true);
filter.setLowerCaseTokens(true);
filter.setOutputWordCounts(true);
filter.setMinTermFreq(minTermFreq);
filter.setNormalizeDocLength(new SelectedTag(StringToWordVector.FILTER_NORMALIZE_ALL,StringToWordVector.TAGS_FILTER));
NGramTokenizer t = new NGramTokenizer();
t.setNGramMaxSize(maxGrams);
t.setNGramMinSize(minGrams);    
filter.setTokenizer(t);     
WordsFromFile stopwords = new WordsFromFile();
stopwords.setStopwords(new File("data/stopwords/stopwords.txt"));
filter.setStopwordsHandler(stopwords);
if (useStemmer){
    Stemmer s = new /*Iterated*/LovinsStemmer();
    filter.setStemmer(s);
}
filter.setInputFormat(trainingData);