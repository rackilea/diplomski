JFrame frame;
JLabel label;
JScrollPane pane;
// ...  
public void init() {
    frame = new JFrame("caption");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension dimension = new Dimension(someDefaultHeight, someDefaultWidth);
    label = new JLabel(); //displays image got from each connection
    JScrollPane pane = new JScrollPane(label, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    frame.getContentPane().add(pane);
    frame.setSize(dimension);
    frame.setVisible(true);
}


public void received(Connection connection, Object object) {
    if (object instanceof Picture) {
        Picture request = (Picture) object;
        try {
            System.out.println(request.buff.length);
            InputStream in = new ByteArrayInputStream(request.buff);
            BufferedImage image = ImageIO.read(in);
            Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
            label.removeAll();
            label.setIcon(new ImageIcon(image));
            frame.setSize(dimension);
            label.revalidate();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }
}