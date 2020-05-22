public static void main(String[] args) throws IOException {
    String path = "img/visualizerLogo3.jpg";
    BufferedImage image = ImageIO.read(new File(path));
    Main contentPane = new Main(image);
    contentPane.setOpaque(true);
    contentPane.setLayout(null);
    JButton submit = new JButton("Load File");
    submit.setLocation(600, 800);
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setContentPane(contentPane);
    f.setSize(1200,1000);
    //f.setLocation(200,200);
    f.setVisible(true);
    f.add(submit);
}