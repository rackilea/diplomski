import javax.swing.*;
import java.awt.event.*;

class FrameDemo {
    public static void main( String [] args ) {
        final JFrame frame = new JFrame("Main frame");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( new JPanel(){{
            add( new JLabel("This is the main content"));
            add( new JButton("Close"){{
                addActionListener( new ActionListener(){
                    public void actionPerformed(ActionEvent e ) {
                        frame.dispose();
                        JOptionPane.showMessageDialog(frame,"IT WORKS!");

                    }
                });
            }});
        }});
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );

    }
}