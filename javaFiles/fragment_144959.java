ActionListener al = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent event) {
        text = textField.getText();
        someFun();
        system.out.println(text);
    }
}