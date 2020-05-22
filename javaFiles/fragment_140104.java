public static void main(String[] args) 
{

   JPanel primary = new JPanel(new BorderLayout());
   primary.setOpaque(true);

   JTextField jt1 = new JTextField(8);
   jt1.setPreferredSize(new Dimension(0, 30));
   primary.add(jt1, BorderLayout.NORTH);


   GridPanel gp = new GridPanel();
   primary.add(gp, BorderLayout.CENTER);

   JFrame jf = new JFrame();
   jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   jf.setPreferredSize(new Dimension(400,200));
   jf.setContentPane(primary);
   jf.pack();
   jf.setVisible(true);

}