private class BackgroundPanel extends JPanel  
    {  
    Image img;  
    public BackgroundPanel()  
    {  
    try  
    {  
    img = Toolkit.getDefaultToolkit().createImage("17.jpg");  
    }  
    catch(Exception e){/*handled in paint()*/}  
    }  
@Override 
public void paintComponent(Graphics g)  
{  
super.paintComponent(g);  
if(img != null) g.drawImage(img, 0,0,this.getWidth(),this.getHeight(),this); 
else g.drawString("No Image",100,100);  
}

}