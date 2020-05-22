CharArraySet stopWordsSet;

try {
    // use customized stop words list
    String stopWordsDictionary = FileUtils.readFileToString(new File(%PATH_TO_FILE%));
    stopWordsSet = WordlistLoader.getWordSet(new StringReader(stopWordsDictionary));
} catch (FileNotFoundException e) {
    // use standard stop words list
    stopWordsSet = CharArraySet.copy(StandardAnalyzer.STOP_WORDS_SET);
}

tokenStream = new StopFilter(new ASCIIFoldingFilter(new ClassicFilter(new LowerCaseFilter(stdToken))), stopWordsSet);
tokenStream.reset();