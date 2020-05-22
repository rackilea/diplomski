DocumentPreprocessor tokenizer = new DocumentPreprocessor(new StringReader(document));
TokenizerFactory<? extends HasWord> factory=null;
factory=PTBTokenizer.factory();
factory.setOptions("untokenizable=noneDelete");
tokenizer.setTokenizerFactory(factory);

for (List<HasWord> sentence : tokenizer) {
    // do something with the sentence
}