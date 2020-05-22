public static void main (String [] args) {
    JFrame frame = new JFrame( G2dTransform_Question.class.getCanonicalName());
    JComponent component = new JComponent() {
        private static final long serialVersionUID = 1L;
        @Override
        protected void paintComponent (Graphics g) {
            super.paintComponent(g);
            paint2D((Graphics2D)g);
        }
        protected void paint2D (Graphics2D g2) {
            AffineTransform tform = AffineTransform.getTranslateInstance( 0, getHeight());
            tform.scale( getWidth(), -getHeight());    // NOTE -- to make 1.0 'full width'.
            g2.setTransform( tform);

            g2.setColor( Color.BLUE);  // NOTE -- so we can *see* something.
            g2.fill( new Rectangle2D.Double(0.1, 0.1, 0.8, 0.8));  // NOTE -- 'fill' works better than 'draw'.
        }
    };

    frame.setLayout( new BorderLayout());    // NOTE -- make the component size to frame.
    frame.add( component, BorderLayout.CENTER);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setVisible(true);
}