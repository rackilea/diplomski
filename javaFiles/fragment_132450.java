public class ProcessRegistry {

  public static class Key {}

  private static final ProcessRegistry INSTANCE = new ProcessRegistry();

  public static ProcessRegistry getInstance() { return INSTANCE; }

  private final Map<Object, Process> _processes = new HashMap<...>();

  public Key registry(Process p) {
    Key key = new Object();
    _processes.put(key, p);
    return key;
  }

  public Process lookup(Key key) {
    return _processes.get(key);
  }
}