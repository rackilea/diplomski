/**
 * Importing JOptionPane for user GUI.
 */
import javax.swing.JOptionPane;
import javax.swing.*;
/**
 * The MyBankController class will control the creation of accounts utilizing the BankAccount class you
created in Part A of the assignment
 * 
 * @author Katarzyna Korzeniec 
 * @version 03/02/2015
 */
public class MyBankController
{
    /**
     * Variables that will be used by this class
     */

    //private BankAccount newAccount;
    private BankAccount accountArray[] = new BankAccount[2];
    int numAccounts = 0;
    int ACCOUNT_SPACES = 2;
     //boolean accountStatus = false;

    /**
     * Constructor for objects of class MyBankController - to be left empty by requirements.
     */
    public MyBankController()
    {
        //
    }

    /**
     * A method to create a new account, accepting user input and allocating memory space. 
     */
    public void createAccount(String customerName, int accountNumber)
    {


        if(numAccounts +1 <= ACCOUNT_SPACES)
        {
            accountArray[numAccounts] = new BankAccount(customerName, accountNumber);

            printAccountDetails(numAccounts);
            numAccounts++;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Sorry, a maximum limit of accounts allowed has been reached." + "\n" + "Limit: " + numAccounts + "/10", "Warning!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Method to print the account details - by calling an object from the BankAccount class.
     */

    private void printAccountDetails(int value)
    {
        JOptionPane.showMessageDialog(null, accountArray[value].toString(), "Account Details", JOptionPane.INFORMATION_MESSAGE);
    }

    public void listAllAccounts()
    {
        String allAccountsString = "List of all accounts: \n";

        for(int i = 0; i < ACCOUNT_SPACES; i++)
        {
            if (accountArray[i] !=null)
            {
                allAccountsString += accountArray[i].toString() + "\n\n" ;

            }

        }
        JOptionPane.showMessageDialog(null, allAccountsString);
    }

    public void listAllOpenAccounts()
    {

        String allAccountsString = "List of all accounts: \n";

        for(int i = 0; i < ACCOUNT_SPACES; i++)
        {
            //allAccountsString += accountArray[numAccounts];
            if (accountArray[i] !=null && (accountArray[i].getAccountStatus() !=false))
            {
                allAccountsString += accountArray[i].toString() + "\n\n" ;
            }
        }
        JOptionPane.showMessageDialog(null, allAccountsString);
    }
}