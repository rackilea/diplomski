public void actionPerformed(ActionEvent ae) 
{
    Thread th1=new Thread();
    lbl.setText("abc");
    try
    {
        th1.sleep(300); 
    }
    catch (Exception e)
    {
        System.out.println(e);
    }
    lbl.setText("ddd:");

}