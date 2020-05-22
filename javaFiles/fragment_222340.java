public class JTextFieldWatched extends JTextField{
  public JTextFieldWatched(String text, JTextFieldWatcher textFieldWatcher){
    super(text);
    if (textFieldWatcher==null){
      // force the constraint
      throw new IllegalArgumentException("textFieldWatcher is mandatory");
    }        
     textFieldWatcher.add(this);
  }
}