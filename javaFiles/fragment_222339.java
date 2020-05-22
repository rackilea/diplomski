public class MyComponent extends JFrame{
  List<JTextField> fields = new ArrayList(); 

  private JTextField textField1;
  private JTextField textField2;
  private JTextField textField3;

  public MyComponent(){
   textField1 = new JTextField ("");
   textField2 = new JTextField ("");
   textField3 = new JTextField ("");
   addTextFieldInList(textField1, textField2, textField3);
  }

  public void addTextFieldInList(JTextField fieldArgs...) {
    fields.addAll(Arrays.asList(fieldArgs));
  }

  public void iterateAllTextFields(){
    for (JTextField field : fields){
      String yourValue = field.getText();
    }    
}