public class ReportCard {
 public static void main (String args[]) {
    JTextField french = new JTextField ("French Grade") ;
    JFrame frame = new JFrame ("Report Card") ;
    frame.setSize(400 , 600) ;
    frame.setVisible(true) ;
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;

    JPanel bigPanel = new JPanel() ;
    frame.getContentPane().add(bigPanel) ;

    bigPanel.add(french) ;