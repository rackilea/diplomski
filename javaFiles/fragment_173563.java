class JFrameList extends JFrame implements ActionListener {
    private JButton jButton1;

    public JFrameList() {
        jButton1 = new JButton("A");
        //set action command, add to input map, add to action map
    }

    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton) event.getSource();
        System.out.println(button.getActionCommand() + " was performed.");
    }
}