public class ClientFactory {
  private final Map<TypeName, Provider> typeToProvider = new HashMap<>();
  // constructing the singleton since the construction needn't be lazy
  private static final ClientFactory INSTANCE = new ClientFactory();

  public static ClientFactory getInstance() {
    return INSTANCE;
  }
// rest is omitted for brevity
}