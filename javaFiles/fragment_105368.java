public Center_Panel() {
    this.setLayout(new GridLayout(1, 2, 10, 10));
    JPanel panel1 = new JPanel(new GridLayout(10, 10));
    panel1.setBackground(Color.BLUE);

    char c = 'A';
    for (int i = 0; i < 10; i++) {    
        for (int j = 0; j < 10; j++) {
           JButton button = new JButton(c + "" + j);
           panel1.add(button);
           button.addActionListener (new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e){

               }});
           //GridCellP1 [i][j] = button;   
        }
        c++;
    }
}