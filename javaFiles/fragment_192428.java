public Client() {
        userText = new JTextArea(); //2, 2
        userText.setLineWrap(true);     // turns on line wrapping
        userText.setWrapStyleWord(true);
        add(userText, BorderLayout.SOUTH);
        System.out.println(userText.getScrollableUnitIncrement(null,SwingConstants.VERTICAL,0));
    }