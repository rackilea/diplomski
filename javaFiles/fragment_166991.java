class CustomeCanvas extends Canvas{
    public void paint(Graphics g){
        Color background = new Color(30,30,120); //Set this accordingly
        for(int i=0;i<getWidth();i++){
            g.setColor(background);
            background = getBrighter(background);
            g.fillRect(i,0, 1, getHeight());
        }
    }

    private Color getBrighter(Color c) {
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();

        if(r< MAX) r+=1;
        if(g< MAX) g+=1;
        if(b< MAX) b+=1;

        return new Color(r,g,b);
    }
}