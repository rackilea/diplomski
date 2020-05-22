MouseListener ml = new MouseAdapter()
{
    public void mouseEntered(java.awt.event.MouseEvent evt)
    {            
        Component c = evt.getComponent();                   
        c.setBackground(new Color(236, 252, 250));
    }                                      

    public void mouseExited(java.awt.event.MouseEvent evt)
    {                                      
        Component c = evt.getComponent();
        c.setBackground(new Color(241, 241, 241));
    }  
}