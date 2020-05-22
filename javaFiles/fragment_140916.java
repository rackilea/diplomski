public class OtherClass extends JPanel {
    JButton jbtnOne;
    JButton jbtnTwo;

    JLabel jlab;
    public OtherClass() {
        // Set the applet to use flow layout.
        setLayout(new FlowLayout());

        // Create two buttons and a label.
        jbtnOne = new JButton("One");
        jbtnTwo = new JButton("Two");

        jlab = new JLabel("Press a button.");

        // Add action listeners for the buttons.
        jbtnOne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent le) {
                jlab.setText("Button One pressed.");
            }
        });

        jbtnTwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent le) {
                jlab.setText("Button Two pressed.");
            }
        });

        // Add the components to the applet's content pane.
        add(jbtnOne);
        add(jbtnTwo);
        add(jlab);
    }
}