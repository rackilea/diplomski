public UI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblDisplayOutNames = new JLabel("Display out names:");
        lblDisplayOutNames.setBounds(32, 25, 121, 16);
        contentPane.add(lblDisplayOutNames);

        JLabel namesOut = new JLabel(""); //here i need to bring the data
        namesOut.setBounds(32, 63, 228, 87);
        contentPane.add(namesOut);

        Logic logic = new Logic();           <<---
        String[] array = logic.message2();       |
                                                 |
        String s = "";                           |
        for (String str : array){                |
            s += str + " ";                      |
        }                                        |
                                                 |
        namesOut.setText(s);                <<----
    }