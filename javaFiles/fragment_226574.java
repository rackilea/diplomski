public class JTextAreaDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {         
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI(){
        final JFrame frame = new JFrame("JTextArea Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea(
                "If there is anything the nonconformist hates worse " +
                "than a conformist, it's another nonconformist who " +
                "doesn't conform to the prevailing standard of nonconformity.", 
                6, 
                20);
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);

        panel.add(textArea);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}