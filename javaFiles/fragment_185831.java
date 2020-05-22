JFrame frame = new JFrame();

        JPanel p1 = new JPanel();
        p1.add(new JButton("11111"));
        JPanel p2 = new JPanel();
        p2.add(new JButton("222222"));
        JPanel p3 = new JPanel();
        p3.add(new JButton("3333"));
        JPanel p4 = new JPanel();
        p4.setPreferredSize(new Dimension(50, 400));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(p1);
        mainPanel.add(p2);
        mainPanel.add(p3);
        mainPanel.add(p4);

        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);