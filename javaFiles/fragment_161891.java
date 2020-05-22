public final class Validator {

   public static boolean validate(final EditText mobile) {
       boolean isSuccess = true;
       String gu_Mobile_No= mobile.getText().toString();
       if (gu_Mobile_No.equals("") || gu_Mobile_No.length() != 10 || gu_Mobile_No.startsWith("0")) {
          mobile.setError(ssbuilder);
          isSuccess = false;
       }
       return isSuccess;
   }
}