class SubmitButtonListener implements ActionListener {

    private JTextField textfield;

    public SubmitButtonListener(JTextField textfield) {
        this.textfield = textfield;
    }

    @Override
    public void actionPerformed(ActionEvent submitClicked) {
        Component frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "You've Submitted the name "
                + textfield.getText());
    }
}