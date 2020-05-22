public static void main(String... args) {

    JButton button = new JButton(new AbstractAction("Button") {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            // Printout to verify that the button was actually pressed
            // since no visual output is shown... :)
            System.out.println("Clicked");
        }
    });

    button.setContentAreaFilled(false);
    button.setBorder(null);

    JFrame frame = new JFrame("Test");
    frame.setLayout(new FlowLayout());
    frame.add(button);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
}