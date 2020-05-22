Eng = new JButton("Bring me to the English version");
Eng.setBounds(250, 20, 300, 20);
Eng.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
        if(StartScherm.frame1.isVisible()) {
           StartScherm.frame1.setVisible(false);
           StartScherm.frame2.setVisible(true);
        } else {
           StartScherm.frame1.setVisible(true);
           StartScherm.frame2.setVisible(false);
        }
   }
});