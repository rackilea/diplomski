public interface Account 
{
    public void calculateInterest();
    public double getInterest(); 
    public String getType(); 
}
...
public class InterestCalculation 
{
    public void getInterestRate(Account objAccount)
    {
        System.out.print ("Interest Rate for "+objAccount.getType()+" is ");
        System.out.print (objAccount.getInterest());
        System.out.println (" %");
    }
}