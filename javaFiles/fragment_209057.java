public class ClassName implements ActionListener {
    private JButton button = new JButton("click me");
    public ClassName() {
        button.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            //perform action
        }
    }
}