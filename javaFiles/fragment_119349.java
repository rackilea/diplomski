panel = new JPanel();
    getContentPane().add(panel, BorderLayout.CENTER);
    panel.setLayout(new CardLayout(100, 100));
    panel.add(P, "name");
    P.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    P.setBackground(new Color(0,0,255));