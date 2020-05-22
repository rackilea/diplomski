public JFrame makeFrame() {
    JFrame f = new JFrame(...);
    JButton next = new JButton("next");
    f.getRootPane().setDefaultButton(next);
    return f;
}

public JDialog makeFrame() {
    JDialog d = new JDialog(...);
    JButton next = new JButton("next");
    d.getRootPane().setDefaultButton(next);
    return d;
}