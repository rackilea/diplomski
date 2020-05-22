btnStart.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        input = (int) (Double.parseDouble(Input.getText()));
        t.start();
    }
});