public class CalebBreckonHW3  {

    public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
        JFrame frame = new JFrame();
        frame.setTitle("Greeting App");
       // frame.setSize(700,700); //not recommened
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         JPanel panel=new JPanel(/*set layout if needed*/); 
         //panel.add(new JButton("Hello")); //add components to panel

        frame.getContentPane().add(panel);//why did you add your JFrame again???? so I guess you'd wanna add a JPanel or something with the components you need.

        frame.pack();
        frame.setVisible(true);
       }

    });
 }
...
}