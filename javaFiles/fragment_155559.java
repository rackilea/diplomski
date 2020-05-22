public static void main(String[] args) {
    final JFrame frame = new JFrame("Test");
    frame.setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final Canvas canvas1 = new Canvas();
    final Canvas canvas2 = new Canvas();
    canvas1.setBackground(Color.RED);
    canvas2.setBackground(Color.BLUE);
    canvas1.addMouseListener(new MouseAdapter() {
        @Override public void mouseClicked(MouseEvent e) {
            frame.remove(canvas1);
            frame.add(canvas2, BorderLayout.CENTER);
            System.out.println("Canvas switched to Canvas2");
            frame.revalidate();
        }
    });

    SwingUtilities.invokeLater(new Runnable() {
        @Override public void run() {
            frame.add(canvas1);
            frame.setSize(640, 480);
            frame.setVisible(true);
        }
    });
}