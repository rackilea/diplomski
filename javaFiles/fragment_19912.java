// changes to code marked with a //!! comment
private void p1ActionPerformed(java.awt.event.ActionEvent evt) {
  String temp = jComboBox1.getSelectedItem().toString();
  ile = Integer.parseInt(temp);

  jPanel1.removeAll();
  jPanel1.setLayout(new GridLayout(ile, ile));

  final JButton[][] buttons = new JButton[ile][ile]; //!!

  for (int i = 0; i < ile; i++) {
     for (int j = 0; j < ile; j++) {
        JButton btn = new JButton();
        btn.setPreferredSize(new Dimension(40, 40));
        btn.setBackground(Color.green);
        btn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
              //!!
              JButton source = (JButton) e.getSource();
              for (int k = 0; k < buttons.length; k++) {
                 for (int l = 0; l < buttons[k].length; l++) {
                    if (buttons[k][l] == source) {
                       System.out.printf("row: %d, col: %d%n", l, k);
                       return;
                    }
                 }
              }
           }
        });
        jPanel1.add(btn);
        buttons[i][j] = btn; //!!
        //!! revalidate();
        //!! pack();
     }
  }
  jPanel1.revalidate(); //!!
  jPanel1.repaint(); //!!
}