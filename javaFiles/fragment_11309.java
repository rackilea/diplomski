public static JTextArea console(final InputStream out, final PrintWriter in) {
    final JTextArea area = new JTextArea();

    // handle "System.out"
    new SwingWorker<Void, String>() {
        @Override protected Void doInBackground() throws Exception {
            Scanner s = new Scanner(out);
            while (s.hasNextLine()) publish(s.nextLine() + "\n");
            return null;
        }
        @Override protected void process(List<String> chunks) {
            for (String line : chunks) area.append(line);
        }
    }.execute();

    // handle "System.in"
    area.addKeyListener(new KeyAdapter() {
        private StringBuffer line = new StringBuffer();
        @Override public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (c == KeyEvent.VK_ENTER) {
                in.println(line);
                line.setLength(0); 
            } else if (c == KeyEvent.VK_BACK_SPACE) { 
                line.setLength(line.length() - 1); 
            } else if (!Character.isISOControl(c)) {
                line.append(e.getKeyChar());
            }
        }
    });

    return area;
}