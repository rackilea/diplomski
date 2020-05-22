public class Gridl extends Applet implements ActionListener
{
     TextField t1=new TextField("    ");

     public void init()
     {
         int n = 1;
         setLayout(new GridLayout(4,4));
         add(t1);
         setFont(new Font("Tahoma",Font.BOLD,24));

         for(int i=0;i<4;i++)
         {
             for(int j=0;j<4;j++)
             {
                 Button b = new Button(""+n));        
                 b.addActionListener(this);
                 this.add(b);
                 n++;
             }
         }  
    }

    public void actionPerformed(ActionEvent ae)
    {
        String str = ae.getActionCommand();
        t1.setText(str);
    }

}