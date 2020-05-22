class RadioListener implements ActionListener { 
   public void actionPerformed(ActionEvent e) {
       pic.setIcon(new ImageIcon(""+e.getActionCommand() + ".jpg"));
running();
   }
}