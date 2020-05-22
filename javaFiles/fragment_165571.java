// onButtonClick
final Card card = cards[index];
card.setBackground(card.getTrueColor());
new Timer(2000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Change color back
        card.setBackground(Color.WHITE);
    } 
}).start();