JPanel upperContainer = new JPanel();
    JPanel lowerContainer = new JPanel();
    upperContainer.setLayout(new GridBagLayout());
    lowerContainer.setLayout(new GridBagLayout());
    // getContentPane().add(upperContainer, BorderLayout.NORTH);
    // getContentPane().add(lowerContainer, BorderLayout.CENTER);
    getContentPane().setLayout(new GridLayout(0, 1));
    getContentPane().add(upperContainer);
    getContentPane().add(lowerContainer);