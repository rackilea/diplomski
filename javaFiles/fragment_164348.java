public class TagPanel extends JPanel {

    public TagPanel(String text) {
        JLabel textlable = new JLabel(text);
        JLabel close = new JLabel("X");
        close.setOpaque(true);
        close.setBackground(new Color(123, 123, 123));
        textlable.setOpaque(true);
        textlable.setBackground(new Color(0,185,203));
        textlable.setForeground(Color.white);
        setLayout(new BorderLayout());
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Example.example.removecomp(TagPanel.this);
            }
        });
        add(close, BorderLayout.EAST);
        add(textlable, BorderLayout.WEST);
    }

}