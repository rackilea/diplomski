public login() {
    //...
    time = new Timer(5000,new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
              dispose();
         }
     });
     timer.setRepeats(false);
}