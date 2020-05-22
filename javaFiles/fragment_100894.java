grammar SearchEngine;


@lexer::members {
  private java.util.Set<String> extraCriteria;

  public SearchEngineLexer(CharStream input, java.util.Set<String> extraCriteria) {
    this(input);
    this.extraCriteria = extraCriteria;
  }

  private boolean isExtraCriteria() {
      return extraCriteria.stream().anyMatch(term -> ahead(term, _input));
  }

  private boolean ahead(final String word, final CharStream input) {
      for (int i = 0; i < word.length(); i++) {
          char wordChar = word.charAt(i);
          int inputChar = input.LA(i + 1);

          if (inputChar != wordChar) {
              return false;
          }
      }

      input.seek(input.index() + word.length() - 1);

      return true;
  }
}

query: expression EOF;

expression: criteria operator literal_value | expression 'AND' expression | expression 'OR' expression;

criteria : 'SERVICE_NAME' | ..a lot of hardcoded criterias here | EXTRA_CRITERIA;

EXTRA_CRITERIA: {isExtraCriteria()}? . ;