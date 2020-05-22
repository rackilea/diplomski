// The same listener instance can handle all buttons
ActionListener actListener = new ActionListener() {     
    @Override
    public void actionPerformed(ActionEvent e) {
        javax.swing.JToggleButton senderButton = (javax.swing.JToggleButton)e.getSource();
        ... // Do anything you want with senderButton here
    }
};
// Add the same listener to all buttons
for (int i = 0 ; i < 36 ; i++) {
    Btn[i].addActionListener(actListener);
}