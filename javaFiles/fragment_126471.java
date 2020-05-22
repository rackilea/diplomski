public static void main(String[] arguments) throws IOException {

    JFrame frame1 = new JFrame();
    frame1.setTitle("Frame1");
    frame1.setSize(500, 500);
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    FlowLayout flo = new FlowLayout();
    frame1.setLayout(flo);

    InputStream resourceAsStream = IconTest.class.getResourceAsStream("strawberry.jpg");
    Image image = ImageIO.read(resourceAsStream);

    JLabel label1 = new JLabel(new ImageIcon(image));
    frame1.add(label1);
    frame1.setVisible(true);
}