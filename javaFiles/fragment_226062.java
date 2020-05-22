Timer dealerTimer= new Timer(1000, new ActionListener() {
    public void actionListener(ActionEvent evt) {
        if (Dealer.getInstance().dealerPoints < 17) {
            Dealer.getInstance().openCard();
        } else {
            ((Timer)evt.getSource()).stop();
        }
    }
});
dealerTimer.setRepeats(true);
dealerTimer.start();