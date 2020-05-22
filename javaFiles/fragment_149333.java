private wampusGUI gui;

//Add Contructor with Parameter

     public Game(wampusGUI w){
      //put this line of code at the end  
      gui=w;
     }

      public void testing () {         
          String welCome=welcome();          
          gui.textArea1(welCome);            
     }