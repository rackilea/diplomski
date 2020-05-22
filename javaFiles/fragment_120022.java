class OutputWindow implements Runnable {

    private String title;
    private JFrame frame;
    private JTextArea outputArea;

    public OutputWindow(String title) {
        this.title = title;
        this.outputArea = new JTextArea(15, 50);
        this.outputArea.setEditable(false);
    }

    @Override
    public void run() {
        frame = new JFrame(this.title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel outputPanel = new JPanel(new FlowLayout());
        outputPanel.add(outputArea);

        frame.add(outputPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public void println(String msg) {
        outputArea.append(msg + "\n");
    }

    public void println(Throwable t) {
        this.println(t.toString());
    }

    public void print(String msg) {
        outputArea.append(msg);
    }

    public void printStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        this.println(sw.toString());
    }

}