public static void main(String[] args) throws Exception {

    final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(20);

    JTextArea area = new JTextArea(10, 40) {{
        addKeyListener(new KeyAdapter() {
            @Override public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_0) {
                    queue.offer(KeyEvent.VK_H);
                    queue.offer(KeyEvent.VK_E);
                    queue.offer(KeyEvent.VK_L);
                    queue.offer(KeyEvent.VK_L);
                    queue.offer(KeyEvent.VK_O);
                }
            }
        });
    }};

    JFrame frame = new JFrame("Test");
    frame.add(area);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);

    Robot robot = new Robot();
    robot.setAutoDelay(50);

    while (true) {
        final int c = queue.take();
        robot.keyPress(c);
        robot.keyRelease(c);
    }
}