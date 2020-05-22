import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

    public class datBoi extends JFrame implements ActionListener{

JButton datBoi;
JLabel jf;
JLabel label;

public datBoi(String title)
{
    super(title);

    datBoi = new JButton("dat boi");
    datBoi.setActionCommand("dat boi");


    datBoi.addActionListener(this);
    jf = new JLabel();
    JPanel panel = new JPanel();
    panel.add(jf);
    getContentPane().add(panel);

    setLayout(new FlowLayout());
    add(datBoi);
    JPanel panel2 = new JPanel();
    getContentPane().add(panel2);

    label = new JLabel();
    panel.add(label);

}

public void actionPerformed( ActionEvent evt)
  {
    // check which command has been sent
    if ( evt.getActionCommand().equals( "dat boi" ) )
    { getContentPane().setBackground(  Color.green  );    
            if(jf.getText().equals("")){
                jf.setText("put your text here");  
            }else{
                jf.setText("");  
            }
            label.setText("GREEN");
    }


    repaint();
  }

  public static void main ( String[] args )
  {
    datBoi demo  = new datBoi( "Get ready to be memed" ) ;

    demo.setSize( 420, 420 );     
    demo.setVisible( true );      
  }
 }