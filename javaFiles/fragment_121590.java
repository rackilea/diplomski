public class CustomPrompt extends JDialog {

  public static String showPrompt(Window parent, String title, String text, 
         String defaultText) {
    final CustomPrompt prompt = new CustomPrompt(parent);
    prompt.setTitle(title);
    // set other components text
    prompt.setVisible(true);

    return prompt.textField.getText();
  }

  private JTextField textField;

  // private if you only want this prompt to be accessible via constructor methods
  private CustomPrompt(Window parent) {
    super(parent, Dialog.DEFAULT_MODALITY_TYPE); 
    // Java >= 6, else user super(Frame, true) or super(Dialog, true);
    initComponents(); // like Netbeans
  }

  // initComponents() and irrelevant code. 
}