final JLabel label = new JLabel("myLabel");

   int delay = 10000; //milliseconds
   ActionListener taskPerformer = new ActionListener() {
       public void actionPerformed(ActionEvent evt) {
           label.setVisible(false)
       }
   };
   new javax.swing.Timer(delay, taskPerformer).start();