public static void main(String... args) throws IOException {
    final JFrame frame = new JFrame("Test");

    JTextField field = new JTextField() {
        @Override
        public Point getToolTipLocation(MouseEvent event) {
            Rectangle position = frame.getBounds();
            return new Point(position.x, position.y);
        }
    };

    field.setToolTipText("test");
    frame.add(field);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
}