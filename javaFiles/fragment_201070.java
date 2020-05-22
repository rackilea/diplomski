add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InputFrame s = new InputFrame();
                Input i = new Input();
                s.add(i.labelPanel);
                s.setVisible(true);
            }
        });