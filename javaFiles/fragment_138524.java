public class DrawingDemo {    
    private JPanel panel;
    private MyImage imageData;

    public DrawingDemo() {
        ...            
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imageData != null) {
                    g.drawImage(imageData.getImage(), imageData.getX(), imageData.getY(), this);
                }

            }
        };
        ...
    }

    public void paintImage(Image image1, int x, int y) {
        imageData = new MyImage(image1, x, y);
        panel.repaint();
    }

    public void anotherMethod() {
        paintImage(...);
        paintImage(...);
    }
}

public class MyImage {    // bean class for storing image information
    private Image image;
    private int x;
    private int y;

    public MyImage(Image image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public Image getImage(){
        return image;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    ... you can add setter methods
}