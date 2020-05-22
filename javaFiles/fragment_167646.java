JButton startButton = new JButton("Start");
startButton.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent ae) {
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
     }
   }
 );