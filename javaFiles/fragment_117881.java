JButton button = new JButton("Show selcted records");
button.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        for (int i = 0; i < model.getRowCount(); i++) {
            Boolean value = (Boolean) model.getValueAt(i, 2);// check state
            if (value) {
                System.out.println(model.getValueAt(i, 1));// second column value
            }
        }
    }
});