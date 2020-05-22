public int findAcct()
  {
      int found = -1;
      System.out.println("Greetings, please enter your account number: ");
      found = scannerObject.nextInt();
      for(int i = 0; i < count; i++){
      if(myAcct[i].getAcctNum() == found){
           found = i;
           break; //Exit out of the loop 
          }
       }          
      return found;
  }