Timer timer = new Timer(100, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evt) {
        //Pop stack coordinates and set them back to ""
        //setText on button clicked to ""
        System.out.println(cardList.getCardNode(row, col).getLetter());        
    }
});
timer.setRepeats(false);
timer.start();