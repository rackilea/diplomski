public class Cache {
  private final Map<String, Optional<String>> mapping = new HashMap<>();

  public Optional<String> get(String key, Suplier<String> supplier) {
    return mapping.computeIfAbsent(key, 
         unused -> Optional.ofNullable(supplier.get()) );
  }
}