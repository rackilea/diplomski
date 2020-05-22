public class SystemOutPrinterFactory {
  private final String prefix;

  public SystemOutPrinterFactory(@Named("prefix") String prefix) {
    this.prefix = prefix;
  }

  public SystemOutPrinter createWithSuffix(String suffix) {
    return new SystemOutPrinter(prefix, suffix);
  }
}