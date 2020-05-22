public class GUI extends JFrame implements MouseListener, ActionListener {
.....
   public GUI {
      GridBagLayout m = new GridBagLayout();
      Container c = getContentPane();
      c.setLayout (m);
      GridBagConstraints con = new GridBagConstraints();
      ....
      JPanel pDraw = new JPanel(new GridLayout(ROWS,COLS,2,2)); 
      con = new GridBagConstraints();
      ...
      m.setConstraints(pDraw, con);

      pDraw.addMouseListener(new MouseAdapter(){
         public void mouseClicked(MouseEvent e) { 
            System.out.println("mouseClicked");
         } 
      });

      pack();         
      setVisible(true);       
   }
}