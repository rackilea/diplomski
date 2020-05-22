public class PaintJPanelApp {


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("Gradient App");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setUndecorated(true);
                frame.setLocationRelativeTo(null);

                JLabel someText = new JLabel("I AM transparent and my JPanel too :)");
                GradientPanel gradientPanel = new GradientPanel();
                gradientPanel.add(someText);
                frame.add(gradientPanel);

                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    static class GradientPanel extends JPanel {


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int w = getWidth(); 
            int h = getHeight();
            Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(new GradientPaint(0, 0, Color.RED, 0, h, Color.WHITE));
            g2d.fillRect(0, 0, w, h);
        }
    }
}