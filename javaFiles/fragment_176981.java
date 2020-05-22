public static void main(String args[]) {

        JComboBox comboBox = new JComboBox();

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.err.println("new item: " + e.getItem());
            }
        });
    }