final JButton continueGame = new JButton();
    JButton dialogOdp;     // declare here
    continueGame.setPreferredSize(new Dimension(1000, 30)); 
    continueGame.setLocation(95, 45);
    continueGame.setText("<html>Continue</html>");
    continueGame.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ev) {
            panel.remove(continueGame);
            SwingUtilities.updateComponentTreeUI(frameKontrastGame);
                if(RandomNrJeden <= 50)
                {
                    JOptionPane.showMessageDialog(frameKontrastGame, "Eggs are not supposed to be green.");
                    dialogOdp = new JButton(); // initialize here


                }
                else
                {
                    JOptionPane.showMessageDialog(frameKontrastGame, "Eggs are not supposed to be red.");
                } 
    }});




//final JLabel im = new JLabel(new ImageIcon("kontrast_logo_2.png"));
//panel.add(im);
if(dialogOdp != null) // check for null
    panel.add(dialogOdp);
panel.add(continueGame);
frameKontrastGame.getContentPane().add(panel);
frameKontrastGame.setLocationByPlatform(true);






}});