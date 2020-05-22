public class MyComponent extends JComponent {

    public void paintComponent(Graphics g) {

        if (this.isOpaque()) {
            // Paint background
            g.setColor(this.getBackground());
            g.fillRect(0,0,this.getWidth(), this.getHeight());
        }

        g.setColor(this.getForeground());
        // Continue painting
    }
}