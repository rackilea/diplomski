public class CustomerAccounts
{
    public Account[] Account {get; set;}
    public Customer Customer {get; set;}
}


public class MonthlyReport() {
   public static void main(String args[]){

         CustomerAccounts[] allData = new CustomerAccounts[totalCustomers];

         //Read in customers
         for (i = 0; i < totalCustomers; i++)
         {
               Customer c = new Customer(customerID, firstName, lastName, mailingAddress, emailAddress, flag, accountNum);
               CustomerAccounts customerAccount = new CustomerAccounts()'
               customerAccount.customer = c;
               allData [i] = customerAccount;

         }

         for (i = 0; i < totalAccounts; i++)
         {
              Account a = new Account(accountNumber, accountType, balance, openingDates, aprAdjustment, feeAdjustment);

              //Look up customer account belongs to to get index in all data array
              int index = lookupIndex();

              CustomerAccounts customerAccount = allData [index];
              int numberOfAccounts = customerAccount.accounts.count;
              allData [index].accounts[numberOfAccounts] = a;
         }
    }