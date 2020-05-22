import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;

    public class SwingExampleDemo {  
      public static void main(String[] args) {  
          JFrame f=new JFrame();//creating instance of JFrame 
          ImageIcon imageIcon = new ImageIcon("C:\\users\\Acer\\Documents\\images\\1.jpg"); //here image path 
          JLabel jLabel = new JLabel(imageIcon);    
          f.add(jLabel);         
          f.setLayout(new FlowLayout());//using layout managers  
          f.setVisible(true);//making the frame visible  
          f.pack();
       }  
    }