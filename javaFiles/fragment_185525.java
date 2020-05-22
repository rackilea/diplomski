public class TextFieldWithLabel {
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextField textField = new JTextField("Search...");
        textField.setLayout(new BorderLayout());

        //creating dummy image...
        Image image = new BufferedImage(25, 25, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 25, 25);
        graphics.setColor(Color.RED);
        graphics.fillRect(2, 11, 21, 3);
        graphics.fillRect(11, 2, 3, 21);

        JLabel label = new JLabel(new ImageIcon(image));
        textField.add(label, BorderLayout.EAST);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField.setText("");
            }
        });
        frame.add(textField);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}