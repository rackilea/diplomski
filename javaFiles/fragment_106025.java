class WhitespaceFilter implements EventFilter {
  @Override
  public boolean accept(XMLEvent event) {
    return !(event.isCharacters() && ((Characters) event)
        .isWhiteSpace());
  }
}