public void paintComponent(Graphics g1) {
    super.paintComponent(g1);
    final Graphics2D g = (Graphics2D)g1.create();
    try {
         // ...Whole lotta drawing code...
    } finally {
         g.dispose();
    }
}