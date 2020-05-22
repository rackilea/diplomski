class ShowComponentHandler implements ActionListener {

    private JComponent component;

    public ShowComponentHandler(JComponent component){
        this.component = component;
    }

    public void actionPerformed(ActionEvent e) {
        component.setVisible(true);
    }
}