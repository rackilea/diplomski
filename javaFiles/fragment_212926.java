JButton b1 = new JButton("add");
b1.addActionListener(e -> {  

    JComboBox<String> color = new JComboBox<String>();
    color.addActionListener(x -> { myFormBean.setColor(color.getSelectedItem();) });
    panel.add(color);

    JTextField name = new JTextField();
    name.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void removeUpdate(DocumentEvent e) {
            myFormBean.setName(name.getText());
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            myFormBean.setName(name.getText());
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            myFormBean.setName(name.getText());
        }
    });
    panel.add(name);

    panel.revalidate();
    panel.repaint();

});