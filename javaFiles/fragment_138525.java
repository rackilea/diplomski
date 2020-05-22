private JPanel panel;
    private ArrayList<MyImage> imageData; // or any other data structure you like

    public DrawingDemo() {
        imageData = new ArrayList<>();
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel() {

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (MyImage myImage : imageData) {
                    g.drawImage(myImage.getImage(), myImage.getX(), myImage.getY(), this);
                }
            }
        };
        frame.add(panel);
        frame.setVisible(true);

    }

    public void paintImage(Image image1, int x, int y) {
        imageData.add(new MyImage(image1, x, y));
        panel.repaint();
    }

    public void anotherMethod() {
        paintImage(new ImageIcon("/home/blackadmin/Desktop/image.jpg").getImage(), 0, 0);
        paintImage(new ImageIcon("/home/blackadmin/Desktop/image2.jpg").getImage(), 50, 50);
        paintImage(new ImageIcon("/home/blackadmin/Desktop/image3.jpg").getImage(), 100, 100);
    }