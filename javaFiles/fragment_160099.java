@Test
public static void main() throws IOException {
 //some code here
  String firstname1 = array.get(2).get(1);
   UserClassExperimental3.userSignup( firstName1 );
}


public class UserClassExperimental3 extends CSVData  {
   public static void userSignup( String firstNameArg ) throws InterruptedException {
     //some code here   
     String firstname = firstnameArg; // Now it works
   } 
}