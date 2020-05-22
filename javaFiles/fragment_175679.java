final JTextArea text = new JTextArea();
    JComboBox combo = new JComboBox();
    combo.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                // assume single selection
                int i = (Integer)e.getItemSelectable().getSelectedObjects()[0];
                text.setText("Selected [" + i + "]");
            }
        }
    });