checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                System.out.println("SELECTED!");
                checkBox.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        if (checkBox.isSelected()) {
                            if (fileChooser.showSaveDialog(checkBox) == JFileChooser.APPROVE_OPTION) {
                                // DIALOG BOX CODE....
                            }
                        }
                    };
                });
            }
        });