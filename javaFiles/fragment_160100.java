@Test
public static void main() throws IOException {
 //some code here
   String firstname1 = array.get(2).get(1);
   UserClassExperimental3 instance = new UserClassExperimental3( firstName1 );
   instance.userSignup();
}

public class UserClassExperimental3 extends CSVData  {
   private String m_firstName;
   public UserClassExperimental3( String firstName ) {
      m_firstName = firstName;
   }
   public void userSignup() throws InterruptedException {
     //some code here   
     String firstname = m_firstname; // Now it works
   } 
}