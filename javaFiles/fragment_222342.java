public class MyComponent extends JFrame{
  private JTextFieldWatcher fieldsWatcher = new JTextFieldWatcher();

  private JTextFieldWatched textField1;
  private JTextFieldWatched textField2;
  private JTextFieldWatched textField3;

  public MyComponent(){
   textField1 = new JTextFieldWatched ("",fieldsWatcher);
   textField2 = new JTextFieldWatched ("",fieldsWatcher);
   textField3 = new JTextFieldWatched ("",fieldsWatcher);
  }   

  public void iterateAllTextFields(){
    for (JTextField field : fieldsWatcher.getAllTextField()){
      String yourValue = field.getText();
    }    
  }
}