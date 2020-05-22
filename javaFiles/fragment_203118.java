JPanel myPanel = new JPanel(){

        @Override    
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(background, bg1.getBgX(), bg1.getBgY(), this);
            g.drawImage(background, bg2.getBgX(), bg2.getBgY(), this);
            g.drawImage(currentSprite, playerChar.getCenterX() - 61, playerChar.getCenterY() - 63, this);
            g.drawString("Score: " + score, 50, 50);


    }