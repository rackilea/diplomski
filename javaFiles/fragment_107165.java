public class help extends JFrame {
        JPanel hold = new JPanel ();
        JTextField enter = new JTextField(10);
        JButton check = new JButton ("Check answer");
        JButton quest = new JButton ("See question");
        JLabel lunch = new JLabel ("Who is the current President of the United States?");

        //Add fields you want to track here
        int scores;
        int fails;

     public help () {