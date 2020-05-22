public class BankProcess {

    // return the  Updated list of BankAccounts
    public TreeMap<Integer,BankAccount> openNewAccount(TreeMap<Integer,BankAccount> bankAccounts,BankAccount bankAccount) {
        //Get the List of existing bank Accounts the add the new BankAccount to it.
        bankAccounts.put(bankAccount.getAccountId(), bankAccount);
        return bankAccounts;
    }

}