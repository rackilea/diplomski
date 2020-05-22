class MyPanel extends JPanel
{
   JTextFeild tf1;
   JLabel label1;
   JLabel label2;
   JTextFeild tf2;
   JLabel label3;

   public MyPanel(String lab1Val, String lab2Val, String lab3Val)
  {
    setLayout(myLayout);
    // create the component tf1, label1, label2, etc instances

    add(tf1);
    add(label2);
    add(tf2);
    add(label3);
    add(tf3);
  }

 @Override
  public Dimension getPreferredSize() {
 }
 }