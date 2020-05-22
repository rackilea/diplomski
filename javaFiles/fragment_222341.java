public class JTextFieldWatcher {
   List<JTextField> fields = new ArrayList(); 

   public void add(JTextField textField){
      fields.add(textField);
   }   

   public List<JTextField> getAllTextField(){
      return new ArrayList(fields);
   }
}