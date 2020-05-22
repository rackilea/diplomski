Class A{ 

 @Autowired 
 @Qualifier("Impl1")
 private Manager manager1; // Impl1

 @Autowired 
 @Qualifier("Impl1")
 private Manager manager2; // Impl2

 // getter setter for manager1 and manager2

 public void performLogic(){
  getUserChoiceManager().doSomething();
 }

 private Manager getUserChoiceManager() {
   // return manager according to user choice
 }
}