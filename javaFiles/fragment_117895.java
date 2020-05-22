//check that now you don't have the next and previous attributes
public class Account {

    private String username;
    private String password;
    private String email;
    private String name;
    private String breed;
    private String gender;
    private String age;
    private String state;
    private String hobby;

    //constructor logic...

    //getters and setters...

    //toString method (for System.out.println)
}

public class MyProgram {
    public void jButtonP1ActionPerformed(java.awt.event.ActionEvent evt) {
        Account account = new Account();
        //set the account data, I'll just stick to username and
        //password attributes
        String username = jTextFieldP3.getText();
        String password = jPasswordFieldP1.getText();
        account.setUsername(username);
        account.setPassword(password);
        //perform the update
        updateData();
    }
    public void updateData(Account account) {
        LinkedList<Account> accountList = new LinkedList<Account>();
        //loading data into our list
        loadDataFromFile(accountList, "myFile.txt");
        //perform the search operation
        ListIterator<Account> li = accountList.listIterator();
        Account accountAux = null;
        while(li.hasNext()) {
            accountAux = li.next();
            //matching the account data outside with the current account
            //of the list iterator, this is just a sample, you can change
            //this logic
            if (accountAux.equals(account) {
                updateAccountData(accountAux, account);
                break;
            }
            accountAux = null;
        }
        //in case the account was not fount in the LinkedList, add it.
        if (accountAux == null)
            accountList.add(account);
        //saving the modified data
        saveDataToFile(accountList, "myFile.txt");
    }
}