public class ImgPanel extends JPanel {

    private int i = 0;
    private List<BufferedImage> imgs;

    public ImgPanel(){
        //init imgs
    }

    public void set(){
        i = 0;
        repaint();
    }

    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);

        if(i >= 0){
            Image img = imgs.get(i-1);
            Image img1 = img.getScaledInstance(100, 100, null);
        }

        g.drawImage(img1, 0, 0, null);
    }

}