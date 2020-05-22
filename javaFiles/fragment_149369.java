int i = 0;

    topPanel.add(button1);
    button1.setToolTipText("Click this button to roll the dice.");
    button1.setForeground(Color.red);
    button1.setContentAreaFilled(false);
    button1.setFocusPainted(false);
    button1.setBorderPainted(false);

    button1.setFont(new Font("Arial", Font.BOLD, 15));
    button1.setPreferredSize(new Dimension(40, 25));
    button1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent event) {

if (i >= 3) {
      button1.setEnabled(false);
    } else {

              die1.roll();
              die1.draw(dk);
              die2.roll();
              die2.draw(dk);
              die3.roll();
              die3.draw(dk);
              die4.roll();
              die4.draw(dk);
              die5.roll();
              die5.draw(dk);
    }
i++;
}