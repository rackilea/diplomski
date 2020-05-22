import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Timer;
import java.io.*;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class tempusFugit extends JFrame implements ActionListener, Serializable, WindowListener
{
    String fileN = "tf.txt";
    public int ToL = 0;
    JLabel jl = new JLabel("" + ToL);

    public tempusFugit()
    {
        Timer timer = new Timer(1000, this);

        setBounds(250, 250, 250, 190);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT) );
        setVisible(true);
        add(jl);
        timer.start();
    }

    public void actionPerformed(ActionEvent e)
    {
        ++ToL;
        jl.setText("" + ToL);
        validate();
        repaint();
    }

    public static void main(String[] args)
    {
        tempusFugit tf = new tempusFugit();
        tf.addWindowListener( tf );
    }

    public void windowDeactivated(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowClosed(WindowEvent e){}

    public void windowClosing(WindowEvent e)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(fileN);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(this);
            out.flush();
            out.close();
            setVisible(false);
            System.exit(0);
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.exit(1);
        }
    }

    public void windowOpened(WindowEvent e)
    {
        try
        {
            tempusFugit tf;// = new tempusFugit();
            FileInputStream fis = new FileInputStream(fileN);
            ObjectInputStream in = new ObjectInputStream(fis);
            tf = (tempusFugit)in.readObject();
            this.ToL = tf.ToL;
            //tf.setVisible(false);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ce)
        {
            ce.printStackTrace();
        }
    }
}