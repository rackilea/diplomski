private class HandlerClass implements ActionListener
{
    // Initializing private String variable that is the same 
    // as the "Card" class' variable - cardName.
    //        private String card = Card.cardName;

    public void actionPerformed(ActionEvent Event) 
    {
        JOptionPane.showMessageDialog(null, "You drew a(n) " + Card.draw());
    }
}