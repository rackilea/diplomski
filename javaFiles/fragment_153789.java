public NuggetPanel() {

        setLayout(new BorderLayout());

        JPanel buttonPane = new JPanel(new GridLayout(12, 12, 2, 2));
        //creates 2D array of buttons
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                // nb: I'd use a "blank" icon which was the same
                // size as the other icons and set it as the 
                // buttons icon, this will ensure that the 
                // buttons are always the right size...
                buttons[i][j] = new JButton("");
                buttons[i][j].setMargin(new Insets(5, 5, 5, 5));
                buttons[i][j].addActionListener(new buttonListener());
                buttonPane.add(buttons[i][j]);
            }

        }

        //adds components
        JPanel LabelPane = new JPanel();
        LabelPane.add(clickCount);
        LabelPane.add(goldCount);
        LabelPane.add(restart);

        add(buttonPane);
        add(LabelPane, BorderLayout.SOUTH);

        restart.setVisible(false);
    }