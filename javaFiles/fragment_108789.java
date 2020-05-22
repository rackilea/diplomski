public class ColoredTextApp {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Colored Text");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                StyledDocument doc = new DefaultStyledDocument();
                JTextPane textPane = new JTextPane(doc);
                textPane.setText("Different Colored Text");

                Random random = new Random();
                for (int i = 0; i < textPane.getDocument().getLength(); i++) {
                    SimpleAttributeSet set = new SimpleAttributeSet();
                    StyleConstants.setForeground(set,
                            new Color(random.nextInt(256), random.nextInt(256),
                                    random.nextInt(256)));
                    StyleConstants.setFontSize(set, random.nextInt(12) + 12);
                    StyleConstants.setBold(set, random.nextBoolean());
                    doc.setCharacterAttributes(i, 1, set, true);
                }

                frame.add(new JScrollPane(textPane));
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}