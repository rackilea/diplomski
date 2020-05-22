final JLabel lblNewLabel = new JLabel("Click Me!");
  lblNewLabel.addMouseListener(new MouseAdapter() {
     @Override
     public void mouseClicked(MouseEvent arg0)
     {
        System.out.println("Label Clicked!");
     }
     @Override
     public void mouseEntered(MouseEvent e)
     {
        lblNewLabel.setBorder(BorderFactory.createEtchedBorder(1));
     }
     @Override
     public void mouseExited(MouseEvent e) 
     {
        lblNewLabel.setBorder(null);
     }
  });