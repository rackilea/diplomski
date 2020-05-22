for (int i=1; i<=100;i++){
    btn[i] = new JButton();
    add(btn[i]);
    btn[i].setText("CLick"+i);
    btn[i].addActionListener(this);
  }