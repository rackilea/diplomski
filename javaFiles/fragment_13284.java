JButton button = new JButton();
button.setText("Some text");
getContentPane().add(button);

button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
           System.exit(0);
      }
});