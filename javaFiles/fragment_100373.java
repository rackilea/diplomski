public class OnlineShopping extends JFrame implements ActionListener {
    //Variable declarations
    private JButton purchaseButton;

    public OnlineShopping() {
        //Create various elements
        purchaseButton = new JButton("Purchase");
        mainPanel.add(purchaseButton);
        purchaseButton.addActionListener(this); //Add the JFrame as a listener
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == purchaseButton) {
            if (regularShippingSpeedRadioButton.isSelected()) {
                //User has chosen to purchase at regular shipping
            } else if (fastShippingSpeedRadioButton.isSelected()) {
                //User has chosen to purchase at fast shipping
            }
        }
    }
}