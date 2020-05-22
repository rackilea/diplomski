calculate.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ev) {
        calculate();
        result.setText(output);
    }
});