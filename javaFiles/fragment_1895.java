grammar YourGrammar;

// options/header/tokens

@parser::members {
  @Override
  public void reportError(RecognitionException e) {
    throw new RuntimeException("I quit!\n" + e.getMessage()); 
  }
}

@lexer::members {
  @Override
  public void reportError(RecognitionException e) {
    throw new RuntimeException("I quit!\n" + e.getMessage()); 
  }
}

// lexer & parser rules