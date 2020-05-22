public class JLabelDemo {
    private static BufferedImage bi;

    public static void main(String[] args) throws IOException{
        loadImage();

        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                createAndShowGUI();             
            }
        });
    }

    private static void loadImage() throws IOException{
        bi = ImageIO.read(JLabelDemo.class.getResource("../resource/forever-alone.jpg"));
    }

    private static void createAndShowGUI(){
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        final JLabel emptyLabel = new JLabel();
        final JLabel textLabel = new JLabel("This label has text only");
        final JLabel textAndImageLabel = new JLabel("This label has text and image");
        textAndImageLabel.setIcon(new ImageIcon(bi));

        panel.add(emptyLabel);
        panel.add(textLabel);
        panel.add(textAndImageLabel);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        System.out.println("Empty label dimensions - " + emptyLabel.getSize());
        System.out.println("Text only label dimensions - " + textLabel.getSize());
        System.out.println("Image width: " + bi.getWidth() + ", Image height: " + bi.getHeight());
        System.out.println("Text and image label dimensions - " +textAndImageLabel.getSize());
    }
}