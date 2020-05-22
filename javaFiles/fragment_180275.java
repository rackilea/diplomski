class ButtonsActionListener implements ActionListener {

    private JButton firstButton;
    private JButton secondButton;

    @Override
    public void actionPerformed(ActionEvent e) {

    if (firstButton == null) {
            firstButton = (JButton) e.getSource();
            firstButton.setBackground(Color.RED);
        } else {
            if (firstButton == (JButton) e.getSource()) {
                firstButton.setBackground(Color.RED);
            } else {
                secondButton = (JButton) e.getSource();
                firstButton.setBackground(null);// reset to original color                    
            }
        }


    }

}