public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(towie,0,0, this);
        g.drawImage(WholeTexture, cX, cY, this);
    }