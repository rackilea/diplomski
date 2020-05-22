public JButton getNumero1() {
     numero1Button = new JButton();
     numero1Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic_images/bt_n1.png")));
     ActionListener monitorador1 = e -> {
        entradaNumero1.setText(("1"));
        entradaNumero1.setEnabled(false);
     };
     numero1Button.addActionListener(monitorador1);
     ActionListener monitorador2 = e -> {
        entradaNumero1.setText(("1"));
        entradaNumero1.setEnabled(false);
     };
     numero1Button.addActionListener(monitorador2);
     return numero1Button;
 }