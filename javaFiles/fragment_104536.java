public final class ColumnDefinitionTypeResolver implements TypeIdResolver {
  // You could rely on static state.
  public static String SOME_ACCESSIBLE_OBJECT = null;

  public ColumnDefinitionTypeResolver() {
    // This is what gets called.
  }
}

ColumnDefinitionTypeResolver.SOME_ACCESSIBLE_OBJECT = "I can affect the implementation from here, but using static state ... be careful";