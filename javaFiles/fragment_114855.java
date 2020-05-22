MainPanel = new JPanel(){
    private static final long serialVersionUID = 1L;

    // the img field should be declared as an instance field and created in the constructor
    // BufferedImage img = new BufferedImage((int)SSize.getWidth(), (int)SSize.getHeight(), BufferedImage.TYPE_INT_ARGB);

    @Override
    protected void paintComponent(Graphics g){

        // first call the super's method
        super.paintComponent(g);

        // file reading should be done once, say in a constructor, not here
        // img = ImageIO.read(FileForBackground); 

        g.drawImage(img, 0, 0, (int)SSize.getWidth(), (int)SSize.getHeight(), 0, 0, 3888, 2592, null);
    }
};