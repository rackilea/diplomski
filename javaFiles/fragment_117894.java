public class Account {

    private Account next;
    private Account previous;
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

public class AccountLinkedList {
    private Account head;
    private int size;
    public AccountLinkedList() {
        this.size = 0;
        this.head = null;
    }
    public boolean insert(Account account) {
        if (this.head == null) {
            this.head = account;
        } else {
            Account current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            //maintain the LinkedList order
            current.setNext(account);
            account.setPrevious(current);
        }
    }
    public Account findAccount(Account account) {
        Account current = head;
        while (current != null) {
            if (current.equals(account) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    //create the other methods to search, delete and traverse your list...
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
        AccountLinkedList accountList = new AccountLinkedList;
        //loading data into our list
        loadDataFromFile(accountList, "myFile.txt");
        //perform the search operation
        Account accountAux = accountList.findAccount(account);
        //if the account is found, then update the accountAux data
        if (accountAux != null) {
            updateAccountData(accountAux, account);
        } else {
            accountList.insert(account);
        }
        //saving the modified data
        saveDataToFile(accountList, "myFile.txt");
    }
}