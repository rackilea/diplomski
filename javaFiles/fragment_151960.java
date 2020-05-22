//Switch panels from start panel to main panel
    main = new JPanel(new BorderLayout());
    menuPanel.setVisible(false);
    remove(menuPanel);
    main.add(gameBoardPanel, BorderLayout.CENTER);

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setPreferredSize(new Dimension(400, 100));
    main.add(buttonsPanel, BorderLayout.SOUTH);