public class SOAnswer extends JFrame{

     private void initComponents(){
          JPanel topPanel = new JPanel(new GridLayout(1, 3, 10, 10));// 1 row, 3 columns

          topPanel.add(new JButton("IMAGE"));
          topPanel.add(new JButton("IMAGE"));
          topPanel.add(new JButton("IMAGE"));

          JPanel bottomPanel = new JPanel(new GridLayout(1, 3, 10, 10));
          bottomPanel.add(new JButton("CLICK ME"));
          bottomPanel.add(new JButton("CLICK ME"));
          bottomPanel.add(new JButton("CLICK ME"));

          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
          setLayout(new BorderLayout(10, 10));
          add(topPanel, BorderLayout.NORTH);
          add(bottomPanel, BorderLayout.CENTER);
          setVisible(true);

     }

     public static void main(String[]args){
          SOAnswer go = new SOAnswer();
          go.initComponents();
     }
}