import static org.junit.Assert.assertTrue;
import org.junit.Test;
public class AccountTest
{
   @Test
   public void currentAccount()
   {
       Account ca = new CurrentAccount();
       assertTrue(ca.applyInterest()==20);
   }
   @Test
   public void savingsAccount()
   {   
       Account sa = new SavingsAccount();
       assertTrue(sa.applyInterest()==30);
   }
}