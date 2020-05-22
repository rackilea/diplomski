// no need for a second thread here
loginButton.addActionListener(new ActionListener() { 
     public void actionPerformed(ActionEvent e) {
         // If you dont want to block the UI Thread make a new Thread here
         new Thread(YOUR_RUNNABLE).start();
     }
}