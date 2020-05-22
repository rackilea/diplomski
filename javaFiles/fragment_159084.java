JTextArea jTextArea = new JTextArea();
    jTextArea.setWrapStyleWord(true);
    jTextArea.setLineWrap(true);

    JScrollPane jScrollPane = new JScrollPane(jTextArea,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);