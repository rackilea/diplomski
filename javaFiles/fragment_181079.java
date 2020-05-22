public class MyComponent extends JComponent {

    private JLabel label = null;

    public MyComponent() {
        super();
    }

    private JLabel getLabel() {
        if (label == null) {
            label = new JLabel();
        }
        return label;
    }

    /**
     * x and y stand for the upper left corner of the label
     * and not for the baseline coordinates ...
     */
    private void paintHtmlString(Graphics g, String html, int x, int y) {
        g.translate(x, y);
        getLabel().setText(html);
        //the fontMetrics stringWidth and height can be replaced by
        //getLabel().getPreferredSize() if needed
        getLabel().paint(g);
        g.translate(-x, -y);
    }

    protected void paintComponent(Graphics g) {
        //some drawing operations...
        paintHtmlString(g, "<html><u>some text</u></html>", 10, 10);
    }
}