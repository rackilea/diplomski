public class App {

    public static void launchView(){
        JFrame frame = new JFrame("Foo");
        frame.setLayout(new MigLayout("fillx, filly, debug", // Layout Constraints
                                "[grow][grow][grow]", // Column Constraints
                                "")); // Row Constraints
        JLabel l = new JLabel("Hello");
        JButton b = new JButton("Help me");
        JLabel l2 = new JLabel("2015-08-06 - 2015-09-32");

        frame.add(l, "align 50% 50%");
        frame.add(b, "align 50% 50%");
        frame.add(l2, "align 50% 50%");
        frame.setSize(new Dimension(600, 200));
        frame.setVisible(true);

    }

    public static void main(String [] args){
       SwingUtilities.invokeLater(new Runnable() {
           @Override
        public void run() {
               launchView();
           }
       });
   }
}