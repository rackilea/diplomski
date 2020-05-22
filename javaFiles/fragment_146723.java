class GUI extends JFrame {
    JTextArea jlist = new JTextArea();

    public GUI(CompletableFuture<GUI> result) {
        this.add(jlist, null);
        result.complete(this);
    }

    public void print(String m) {
        jlist.append(m);
    }

}

public static void main (String[]args) throws Exception {
    CompletableFuture<GUI> result = new CompletableFuture();
    EventQueue.invokeLater(() -> new GUI(result));
    GUI gui = result.get();
    // compute something
    long time = System.currentTimeMillis();
    // pass computed value to GUI
    EventQueue.invokeLater(() -> gui.print("time="+time));
}