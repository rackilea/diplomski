import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;

public class FileChooserSave
{
    private static void createAndShowUI()
    {
        final JFileChooser chooser = new JFileChooser( new File(".") )
        {
            public void approveSelection()
            {
                if (getSelectedFile().exists())
                {
                    int n = JOptionPane.showConfirmDialog(
                        this,
                        "Do You Want to Overwrite File?",
                        "Confirm Overwrite",
                        JOptionPane.YES_NO_OPTION);

                    if (n == JOptionPane.YES_OPTION)
                        super.approveSelection();

                }
                else
                    super.approveSelection();
            }
        };

        chooser.setSelectedFile( new File("something.rob") );
        int returnVal = chooser.showSaveDialog(null);


        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
           System.out.println(chooser.getSelectedFile() );
        }
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}