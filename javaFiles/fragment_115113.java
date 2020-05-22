public static void main(String[] args) {
    JFrame frame = new JFrame("Title");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);

    JTextArea textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textArea);

    frame.add(scrollPane);
    frame.setVisible(true);

    Thread thread = new Thread(new Runnable() {
        @Override public void run() {
            for (int i = 0; i < 5; i++) {
                textArea.append("hello\n");
                try { Thread.sleep(500); } catch (InterruptedException ex) { }
            }
        }
    });
    thread.start();
}