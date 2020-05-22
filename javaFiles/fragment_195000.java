for (int i = 0; i < 10; i++) {
    final JTextPane tp = new JTextPane();
    final DefaultCaret caret = (DefaultCaret) tp.getCaret();
    caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
    tp.setText("This is some text in text pane " + i);
    p.add(tp);

    // adding some other components simply leaves the scrollPane at the top
    // JComponent b = new JButton("This is some text in button "
    // + i);
    // p.add(b);
}

final JFrame f = new JFrame();
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.getContentPane().add(new JScrollPane(p));