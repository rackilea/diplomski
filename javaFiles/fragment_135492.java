public void paintComponent(Graphics g) {
    //System.out.println(gameInProgress);

    if(gameInProgress == true) {
        super.paintComponent(g);

        //Add a couple new variables
        int x = 115;

        Graphics2D g2 = (Graphics2D) g;
        Image image = null;
        int i;
        for (i = 0; i < 4; i++) {
            image = Toolkit.getDefaultToolkit().getImage("images/"+deck[i]+".png");
            //New location of g2.drawImage
            //The X positions should change each time
            g2.drawImage(image, x, 5, 80, 107, this);
            //Change the X location of the next image
            x = x + 80;
        }
        //Moved g2.drawImage from here to above the bracket
        g2.finalize();
    }
}