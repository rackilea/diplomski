private void loadListener1() {
    view1.submitButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            model.setData1(view1.data1Field.getText()),
            model.setData2(view1.data2Field.getText());
            model.makeChange();
        }
    });
}