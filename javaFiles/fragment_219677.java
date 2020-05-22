combo.addItemListener(new ItemListener() {

        @Override
        public void itemStateChanged(ItemEvent event) {
            String fontName = combo.getSelectedItem().toString();

            if (event.getStateChange() == ItemEvent.SELECTED) {
                label3.setText(tf1.getText());
                label3.setFont(new Font(fontName, Font.PLAIN, 14));
            } 
        }
    });