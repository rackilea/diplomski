public class YourClassName{
   private static boolean checkEmailValidation(EditText e) { 
      String mail = e.getText().toString()
      if (mail.isEmpty()) {
          e.setError("Field cannot be empty");
          return false;
      } else if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
          e.setError("Not a valid email"); 
          return false;
      } else if (mail.length()>254) {
          e.setError("Email to long");
          return false;
      }else if (mail.length()<5) {
          e.setError("Email too short");
          return false;
      }else {
          e.setError(null);
          // e.setErrorEnabled(false);
          return true;
      }
   }
}