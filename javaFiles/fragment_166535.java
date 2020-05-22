public class Calc {

public static void addComponentsToPane(Container pane) {

    pane.setLayout(new GridBagLayout());
    GridBagConstraints gBC = new GridBagConstraints();

    gBC.ipady = 40;
    gBC.ipadx = 40;

    JTextField JTextField = new JTextField("Hello");
    gBC.fill = GridBagConstraints.HORIZONTAL;
    gBC.gridx = 0;
    gBC.gridy = 0;
    gBC.gridwidth = 4;
    JTextField.setEditable(false);
    pane.add(JTextField, gBC);

    //JButton jbnButton;
    gBC.gridwidth = 1;

    JButton b7 = new JButton("7");
    gBC.gridx = 0;
    gBC.gridy = 1;
    pane.add(b7, gBC);
    // more calculator buttons declared here

    b7.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Write your action here

        }
    });

}

private static void createAndShowGUI(JFrame pane) {
    addComponentsToPane(pane);
    pane.setVisible(true);
}

public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            createAndShowGUI(new JFrame());
        }
    });
}