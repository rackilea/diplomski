Action logSelected = new TextAction("log selected") {

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextComponent text = getTextComponent(e);
            System.out.println("selected: " + text.getSelectedText());
        }

    };

    JComponent content = new JPanel();
    content.add(new JTextField("sometext", 20));
    content.add(new JTextField("other content", 20));
    content.add(new JCheckBox("just some focusable comp"));
    content.add(new JButton(logSelected));