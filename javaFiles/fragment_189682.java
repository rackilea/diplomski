public int findAcct()
  {
      int found = -1;
      boolean foundMatch = false;
      System.out.println("Greetings, please enter your account number: ");
      found = scannerObject.nextInt();
      for(int i = 0; i < count; i++){
      if(!foundMatch){
      if(myAcct[i].getAcctNum() == found){
           found = i;
           foundMatch = true; //we will no longer search
          }
       }
       }          
      return found;
  }