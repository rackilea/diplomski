public class DrawPanel extends JPanel {
    BufferedImage smileyFace;

    public DrawPanel() {
        try{
            smileyFile = new File("C:\\Users\\MyName\\Desktop\\smiley.png");
            smileyFace = ImageIO.read(smileyFile);
        } 
        catch (Exception e){
            System.out.println("There was an error finding or reading the file \" smiley.png.\"");
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(smileyFace,50,50, this);
    }

    @Override 
    public Dimension getPreferredSize(){
        return new Dimension(500, 500);
    }
}