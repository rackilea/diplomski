public class TestFrame extends JFrame {

    private JTextArea text;

    public TestFrame() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("Text");

        setLayout(new BorderLayout());
        text = new JTextArea();
        add(new JScrollPane(text));

        JButton btnPrint = new JButton("Print");
        add(btnPrint, BorderLayout.SOUTH);

        btnPrint.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                BufferedImage img = new BufferedImage(text.getWidth(), text.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = img.createGraphics();
                text.printAll(g2d);
                g2d.dispose();

                try {
                    ImageIO.write(img, "png", new File("StringToGraphics.png"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

        text.setWrapStyleWord(true);
        text.setColumns(15);
        text.setLineWrap(true);
        text.setText("I have a string which is displayed in my program, but I'm wondering how I would convert the output of the string into an image identical to the original string. No idea if this can be done.\n\nI would like the output to be exactly what is is the JTextArea. Is this possible and if so what should I look into?");

        setSize(200, 300);

        setLocationRelativeTo(null);
        setVisible(true);

    }

}