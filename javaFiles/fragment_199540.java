btn1.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (text.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please enter anything");
        }
        JOptionPane.showMessageDialog(rootPane, "Hello : " + text.getText());
    }
});