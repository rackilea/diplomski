public class SafeAccount extends Account
{

   public SafeAccount(double amount)
   {
     super(Math.max(0.0, amount));
   }
}