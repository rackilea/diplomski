t.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        TextField tf = (TextField) e.getSource();
        System.out.println(tf.getText());
    }
});