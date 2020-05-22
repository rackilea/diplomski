public enum Bracket {
  OPEN_BRACKET('{'), CLOSE_BRACKET('}');

  private final char symbol;

  Brackets(char symbol) {
      this.symbol = symbol;
  }

  public char getSymbol() {
      return symbol;
  }    
}