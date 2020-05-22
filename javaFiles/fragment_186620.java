public final class NSValidator {
  private NSValidator() {
  }

  private static final NamespaceContext INSTANCE = new NamespaceContext() {
    @Override public String getNamespaceURI(String prefix) {
      return null;
    }

    @Override public String getPrefix(String namespaceURI) {
      return null;
    }

    @Override public Iterator<?> getPrefixes(String namespaceURI) {
      return Collections.emptyList()
          .iterator();
    }
  };

  public static NamespaceContext noNamespaces() {
    return INSTANCE;
  }
}