if (e.getActionCommand().equals("Search")) {
     final String strSearchString = searchTextField.getText();
     System.out.println(strSearchString);
     String text = outTextArea.getText();
     System.out.println(text);
     final Scanner sc = new Scanner(text);
     int timerDelay = 2 * 1000;

     new Timer(timerDelay, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
           if (sc.hasNext()) {
              String s = sc.next();
              if (s.equals(strSearchString)) {
                 searchOutLabel.setText("Yes");
              } else {
                 searchOutLabel.setText("Non!");
              }
           } else {
              ((Timer)e.getSource()).stop();
              sc.close();
           }
        }
     }).start();
  }