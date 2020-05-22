Action class : 
 static Account[] account=new Account[1];
 static String[] arrayofStrings={"1","2","4"};
 {
    Account a=new Account();
    a.setName(arrayofStrings);
    account[0]=a;

 } 

 //..getters and setters , execute()

  public String[] getArrayofStrings() {
    return this.account[0].getName();//Just like yours
  }