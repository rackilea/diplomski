@Override
public void actionPerformed(ActionEvent event) {
    Object source = event.getSource();
    if (source == somethingButton) {
        answer.setText("Button pressed!");
        setVisible(false);  // hide something            
        JOptionPane.showMessageDialog(this, "Something", "Message Dialog",JOptionPane.PLAIN_MESSAGE);
        setVisible(true);  // show something 
    }
}