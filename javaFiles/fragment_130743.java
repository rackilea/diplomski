public interface IDictionaryListener {
  void dictionaryChanged(IDictionary from, IDictionary to);
}

public interface IDictionary {
  String getString(String forKey);
}

public final class DictionaryManager {
  private static final DictionaryManager INSTANCE=new DictionaryManager();
  private final List<IDictionaryListener> listeners=new ArrayList<>();
  private IDictionary dictionary;

  private DictionaryManager() {};

  public static synchronized void setDictionary(IDictionary dict) {
    IDictionary old = INSTANCE.dictionary;
    INSTANCE.dictionary=dict;
    fireDictionaryChanged(old, dict);
  }

  public static synchronized IDictionary getDictionary() {
    return INSTANCE.dictionary;
  }

  public static synchronized void addDictionaryListener(IDictionaryListener l) {
    INSTANCE.listeners.add(l);
  }

  public static synchronized void removeDictionaryListener(IDictionaryListener l) {
    INSTANCE.listeners.remove(l);
  }

  private static void fireDictionaryChanged(IDictionary from, IDictionary to) {
    for (IDictionaryListener l:INSTANCE.listeners) {
      l.dictionaryChanged(from, to);
    }
  }

}

public class DictionaryLabel extends JLabel implements IDictionaryListener {
  private String key;

  public DictionaryLabel(String dictKey) {
    super();
    key = dictKey;
    DictionaryManager.addDictionaryListener(this);
    super.setText(DictionaryManager.getDictionary().getString(key));
  }

  @Override
  public final void setText(String text) {
    throw new RuntimeException("Not supported! Dictionary is used for this!");
  }

  @Override
  public void dictionaryChanged(final IDictionary from, final IDictionary to) {
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        DictionaryLabel.super.setText(to.getString(key));
      }

    });
  }
}