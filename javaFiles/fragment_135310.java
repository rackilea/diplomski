label.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {  
       // you can open a new frame here as
       // i have assumed you have declared "frame" as instance variable
       frame = new JFrame("new frame");
       frame.setVisible(true);

    }  
});