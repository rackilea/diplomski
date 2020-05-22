@Override
  public List<Rule> getRelevantRules(ResourceBundle messages) throws IOException {
    return Arrays.asList(
new CommaWhitespaceRule(messages),
new DoublePunctuationRule(messages),
new GenericUnpairedBracketsRule(messages,
Arrays.asList("[", "(", "{" /*"«", "‘"*/),
Arrays.asList("]", ")", "}"
/*"»", French dialog can contain multiple sentences. */
/*"’" used in "d’arm" and many other words */)),
new MorfologikYourLanguageSpellerRule(messages, this),
new UppercaseSentenceStartRule(messages, this),
new MultipleWhitespaceRule(messages, this),
new SentenceWhitespaceRule(messages),
// specific to French:
new CompoundRule(messages),
new QuestionWhitespaceRule(messages)
);
}