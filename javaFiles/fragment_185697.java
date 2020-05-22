java.awt.EventQueue.invokeLater(() -> {
    JFrame frm = new JFrame();
    JPanel pnl = new JPanel();
    frm.add(pnl);
    pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
    pnl.add(new JLabel("Class"));
    JTextField classField = new JTextField();
    pnl.add(classField);
    pnl.add(new JLabel("Method"));
    JTextField methodField = new JTextField();
    pnl.add(methodField);
    JTextArea area = new JTextArea();
    area.setPreferredSize(new Dimension(300, 300));
    JButton btn = new JButton("Run");
    pnl.add(btn);
    pnl.add(area);
    System.setOut(new PrintStream(new OutputStream() {
        @Override
        public void write(int b) throws IOException {
            area.append(new String(new byte[]{(byte) b}));
        }
    }));
    btn.addActionListener(e -> {
        try {
            Class cls = Class.forName(classField.getText());
            Method m = null;
            Method ma[] = cls.getDeclaredMethods();
            String methodName = methodField.getText().trim();
            m = cls.getMethod(methodName,new Class[]{});
            Object o = cls.newInstance();
            Object mr = m.invoke(o);
            if(null != mr) {
                area.append("\nreturned "+mr.toString()+"\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            area.append("\nException "+ex.getMessage()+"\n");
        }
    });
    frm.pack();
    frm.setVisible(true);
});