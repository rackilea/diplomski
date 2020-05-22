public class CalebBreckonHW3  extends JFrame{

    public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
        new CalebBreckonHW3().createandShowUI();
       }

    });
 }
 private void createAndShowUI() {
        setTitle("Greeting App");
        //setSize(700,700); //not recommened
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         JPanel panel=new JPanel(/*set layout if needed*/); 
         //panel.add(new JButton("Hello")); //add components to panel

        getContentPane().add(panel);//why did you add your JFrame again???? so I guess you'd wanna add a JPanel or something with the components you need.

        pack();//this will override setsize and use LayoutManager
        setVisible(true);     
 }
...
}