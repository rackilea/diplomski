class AnimationTask implements ActionListener {
    private int cardID;
    private int xDest;
    private int yDest;
    private int totalXDistance;
    private int totalYDistance;
    public AnimationTask(int cardID, int xDest, int yDest) {
       this.cardID = cardID;
       this.xDest = xDest;
       this.yDest = yDest;
       this.totalXDistance = Math.abs(xDestination - START_POSITION_X);
       this.totalYDistance = Math.abs(yDestination - START_POSITION_Y);
    }

    public void actionPerformed(ActionEvent e) {
         // do your animation logic...
    }
}