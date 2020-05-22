import java.awt.*;
import java.awt.image.BufferedImage;    
import javax.swing.*;


public class CustomPanel extends JPanel{ 

    Component myComponent;

    public CustomPanel(){
        super();
        setLayout(null);
    }

    /**
     * Only allows one component to be added
     */
    @Override
    public Component add(Component c){
        super.add(c);
        c.setLocation(0, 0);
        c.setSize(c.getPreferredSize());
        myComponent = c;
        return c;
    }

    @Override
    public void paint(final Graphics g){

        Dimension d = this.getSize();               
        Dimension p = myComponent.getPreferredSize();

        // Paints the child component to a image
        BufferedImage newImg = new BufferedImage(p.width, p.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = newImg.createGraphics();
        super.paint(g2d);

        // Resizes the image if necessary
        Image img;
        if(d.height > p.height && d.width > p.width){
            System.out.println("Scaled");

            float changePercentage = 0;
            if(d.height/p.height > d.width/p.width){
                changePercentage = (float)d.width/(float)p.width;
            } else{
                changePercentage = (float)d.height/(float)p.height;
            }
            System.out.println(changePercentage);

            int newHeight = ((Float)(p.height * changePercentage)).intValue();
            int newWidth = ((Float)(p.width * changePercentage)).intValue();

            img = newImg.getScaledInstance(newWidth, newHeight, 0);             
        } else{
            System.out.println("Not Scaled");
            img = newImg;
        }

        // Paints the image of the child component to the screen.
        g.drawImage(img, 0, 0, null);
    }

    public static void main(String[] args) { 
        // TODO Auto-generated method stub 
        SwingUtilities.invokeLater(new Runnable(){public void run(){

            JFrame frame = new JFrame("Zoom Panel"); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            frame.setSize(300, 200); 

            CustomPanel buffer = new CustomPanel();
            JPanel content = new JPanel();
            content.add(new JLabel("Bogus"));
            content.setBackground(Color.red);
            buffer.add(content);
            frame.setContentPane(buffer);

            frame.setVisible(true); 
            new CustomPanel();

        }}); 
    } 

}