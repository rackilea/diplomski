void start(int numofplayer_int) {
        JLayeredPane lpane = new JLayeredPane();
        lpane.setBounds(0, 0, 1200, 750);

        JPanel background = new WallPaper();
        //background.setBounds(0, 0, 1200, 750);
        background.setOpaque(true);

        //this.setBounds(100, 100, 400, 400);
        this.setBounds(0,0,1200,750);
        this.setOpaque(false);

        lpane.add(background, new Integer(0), 0);
        lpane.add(this, new Integer(1), 0);

        Utility.ChangeJLPanel(lpane);
}