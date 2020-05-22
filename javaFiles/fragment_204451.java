//Delete account
public void deleteAccount() {
     System.out.println("\nPlease enter the ID of the account you wish to    delete:");
     id = in.nextInt(); //take user input of id to delete
     Iterator<Account> iAccount = accounts.iterator();
     while(iAccount.hasNext()){
          Account account = iAccount.next();
          if(account.getId()==id){
                accounts.remove(account);
          }
     }
 }