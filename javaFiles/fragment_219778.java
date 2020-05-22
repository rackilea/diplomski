btnAddFiles_1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        ...
        final String[][] data = {{"01.", node, }}; // node is not accessible here
        ...
    }
});