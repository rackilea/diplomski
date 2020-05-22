final ImageIcon icon = new ImageIcon(Testing.class.getResource("/btn/resources/balloon80.jpg"));
radioButtonRight.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
      btnRight.setIcon(icon);
      btnLeft.setIcon(null);
   }
});

radioButtonLeft.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        btnRight.setIcon(null);
        btnLeft.setIcon(icon);
    }
});