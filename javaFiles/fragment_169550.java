import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SaveEditor extends JFrame implements ActionListener{
     public static final String text = "As told by Wikipedia\n"
    +"Java is a general-purpose, concurrent, class-based, object-oriented computer programming language."
    + "It is specifically designed to have as few implementation "
    + "dependencies as possible. It is intended to let application developers write once, run anywhere (WORA), "
    + "meaning that code that runs on one platform does not need to be recompiled to run on another. "
    + "Java applications are typically compiled to bytecode (class file) that can run on any Java virtual "
    + "machine (JVM) regardless of computer architecture. Java is, as of 2012, one of the most popular programming "
    + "languages in use, particularly for client-server web applications, with a reported 10 million users.";
    JTextPane pane ;
    DefaultStyledDocument doc ;
    StyleContext sc;
    JButton save;
    JButton load;
    public static void main(String[] args) 
    {
        try 
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    SaveEditor se = new SaveEditor();
                    se.createAndShowGUI();
                }
            });
        } catch (Exception evt) {}
    }
    public void createAndShowGUI()
    {
        setTitle("TextPane");
        sc = new StyleContext();
        doc = new DefaultStyledDocument(sc);
        pane = new JTextPane(doc);
        save = new JButton("Save");
        load = new JButton("Load");
        JPanel panel = new JPanel();
        panel.add(save);panel.add(load);
        save.addActionListener(this);load.addActionListener(this);
        final Style heading2Style = sc.addStyle("Heading2", null);
        heading2Style.addAttribute(StyleConstants.Foreground, Color.red);
        heading2Style.addAttribute(StyleConstants.FontSize, new Integer(16));
        heading2Style.addAttribute(StyleConstants.FontFamily, "serif");
        heading2Style.addAttribute(StyleConstants.Bold, new Boolean(true));
        try 
        {
            doc.insertString(0, text, null);
            doc.setParagraphAttributes(0, 1, heading2Style, false);
        } catch (Exception e) 
        {
            System.out.println("Exception when constructing document: " + e);
            System.exit(1);
        }
        getContentPane().add(new JScrollPane(pane));
        getContentPane().add(panel,BorderLayout.SOUTH);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent evt)
    {
        if (evt.getSource() == save)
        {
            save();
        }
        else if (evt.getSource() == load)
        {
            load();
        }
    }
    private void save()//Saving the contents .
    {
        JFileChooser chooser = new JFileChooser(".");
        chooser.setDialogTitle("Save");
        int returnVal = chooser.showSaveDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) 
        {
            File file = chooser.getSelectedFile();
            if (file != null)
            {
                FileOutputStream fos = null;
                ObjectOutputStream os = null;
                try
                {
                    fos = new FileOutputStream(file);
                    os = new ObjectOutputStream(fos);
                    os.writeObject(doc);
                    JOptionPane.showMessageDialog(this,"Saved successfully!!","Success",JOptionPane.INFORMATION_MESSAGE);
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
                finally
                {
                    if (fos != null)
                    {
                        try
                        {
                            fos.close();
                        }
                        catch (Exception ex){}

                    }
                    if (os != null)
                    {
                        try
                        {
                            os.close();
                        }
                        catch (Exception ex){}

                    }
                }
            }
            else 
            {
                JOptionPane.showMessageDialog(this,"Please enter a fileName","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void load()//Loading the contents
    {
        JFileChooser chooser = new JFileChooser(".");
        chooser.setDialogTitle("Open");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) 
        {
            File file = chooser.getSelectedFile();
            if (file!= null)
            {
                FileInputStream fin = null;
                ObjectInputStream ins = null;
                try
                {
                    fin = new FileInputStream(file);
                    ins = new ObjectInputStream(fin);
                    doc = (DefaultStyledDocument)ins.readObject();
                    pane.setStyledDocument(doc);
                    JOptionPane.showMessageDialog(this,"Loaded successfully!!","Success",JOptionPane.INFORMATION_MESSAGE);
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
                finally
                {
                    if (fin != null)
                    {
                        try
                        {
                            fin.close();
                        }
                        catch (Exception ex){}

                    }
                    if (ins != null)
                    {
                        try
                        {
                            ins.close();
                        }
                        catch (Exception ex){}

                    }
                }
            }
            else 
            {
                JOptionPane.showMessageDialog(this,"Please enter a fileName","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}