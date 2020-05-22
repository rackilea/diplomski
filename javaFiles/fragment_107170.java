//When creating a quest 
  Q1 = new Quest1();
  Q1.setCB(new CallBack{
      public void callBack(){
          CheckQuests(); //this tells the program what to do when it hears back from Q1
      }
  }