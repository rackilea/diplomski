panel.add(box1);
    panel.add(box2);
    panel.add(clean);

    clean.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            Component[] components = panel.getComponents();
            for (Component component : components) {
                if (component instanceof  JCheckBox) {
                    JCheckBox checkBox = (JCheckBox) component;
                    if(checkBox.isSelected()) {                     
                    checkBox.setSelected(false);
                    }
                }
            }
        }
    });