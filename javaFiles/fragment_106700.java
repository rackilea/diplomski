public class SearchTextFile2 {

    private static void createAndShowGui() {
        BufferedImage img = null;
        try {
            // better to get as a resource and not as a File
            img = ImageIO.read(new File("bible.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("SearchTextFile2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TestPane(img)); // pass image into TestPane
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }

    // make TestPane a static inner class
    // have TestPane display image within its paintComponent method
    public static class TestPane extends JPanel {
        private JTextField findText;
        private JButton search;
        private DefaultListModel<String> model;
        private JList list;
        private BufferedImage img;
        private String searchPhrase;

        public TestPane(BufferedImage img) {
            setLayout(new BorderLayout());
            this.img = img;
            // etc.....
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (img != null) {
                g.drawImage(img, 0, 0, this);
            }
        }
        // .....