JFrame f = new JFrame();
    f.setLayout(new BorderLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel p = new JPanel(new GridLayout(0, 5));
    JScrollPane jsp = new JScrollPane(p);

    jsp.setPreferredSize(new Dimension(300,300));
    jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

    for (int i = 0; i < 100; i++) {
        JButton b = new JButton("Button " + i);
        p.add(b);
    }

    f.add(jsp, BorderLayout.CENTER);
    f.setLocation(300, 300);
    f.setVisible(true);
    f.pack();