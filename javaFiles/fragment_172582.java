public void actionPerformed(ActionEvent e) {

if( e.getSource() instanceof JRadioButton){

  String selectedRadioName = ((JRadioButton) e.getSource()).getName();

  JOptionPane.showMessageDialog( null, selectedRadioName );

}