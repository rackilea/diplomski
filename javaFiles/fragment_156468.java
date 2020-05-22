//BEFORE the loop
AccountOptions customer; 
TreeSet<AccountOptions> accountOptionsSet= new TreeSet<>();
do { 
    //INSIDE the loop 
    customer = new Account_Options() 
    ... rest of loop / instance-creation logic  
    accountOptionsSet.add(customer); //store the object before it gets overridden by the next. 
    ... 
 } while(!again);

 //AFTER the loop 
System.out.println("\n"+"Tree set data: ");

Iterator <AccountOptions> accountOptionsIterator = accountOptionsSet.iterator();
while (accountOptionsIterator.hasNext()){
    System.out.println(accountOptionsIterator.next());
}