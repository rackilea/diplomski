class ShowButtonHandler implements ActionListener {

    private JButton btnNew;

    public ShowButtonHandler(JButton btnNew){
        this.btnNew = btnNew;
    }

    public void actionPerformed(ActionEvent e) {
        btnNew.setVisible(true);
    }
}