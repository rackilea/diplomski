public class Results extends JFrame {

    private int doble;

    public Results() {
        // Create a JPanel for the buttons DOUBLE AND NOT DOUBLE
        JPanel duplicate = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton doblebutton = new JButton("DOUBLE");
        doblebutton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                doble++;
                System.out.println("Doubles: " + doble);
            }
        });
    }

    public static void main(String[] args) {
        Results results = new Results();
        System.out.println(results.doble);
    }

}