private static class ButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        //which button?
        int buttonIndex = buttonz.indexOf(e.getSource());

        //drop box, check win and show message 
        if (redTurn) {
            dropRedBox(buttonIndex);
            if (winCheck("red")) {
                JOptionPane.showMessageDialog(null, "Red wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            dropYellowBox(buttonIndex);
            if (winCheck("yellow"))
                JOptionPane.showMessageDialog(null, "Yellow wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}