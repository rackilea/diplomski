class Mozijegy { 
      ClassX classX;
      ...
      Mozigegy (ClassX classX) { //along with whatever other params you need 
         this.classX= classX;
         ...
      }
      ...
      buttonC.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
             classX.doWhenButtonCisClicked();
          }
       });
 }