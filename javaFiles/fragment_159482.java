public GridLayoutFrame() {
        super("Calculator");
        Bottom = new JPanel();
        Top = new JPanel();
        Top.setLayout(new GridBagLayout()); // Three Rows (first row must
                                                    // only show a text field
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;


        topButton = new JButton[topButtons.length];

        Input.setSize(500, 500);
        Input.setEditable(false);
        Input.setBackground(Color.WHITE);
        Input.setPreferredSize(new Dimension(300, 30));

        c.gridwidth = 5;
        Top.add(Input, c);
        c.gridwidth = 1;


        for (int count = 0; count < topButtons.length; count++) {
            topButton[count] = new JButton(topButtons[count]);
            c.gridx = count % 5;
            Top.add(topButton[count], c ); // add button to panel
        }

        Bottom.setLayout(new GridLayout(5, 5, 10, 10));
        buttons = new JButton[names.length];
        for (int count = 0; count < names.length; count++)

        {
            buttons[count] = new JButton(names[count]);
            Bottom.add(buttons[count]); // add button to panel
        }

        add(Top, BorderLayout.NORTH);
        add(Bottom,BorderLayout.CENTER);