import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class Ironmantis extends JFrame{
    JTextArea textArea = new JTextArea();
    JPanel upperPanel = new JPanel();
    JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,upperPanel,new JScrollPane(textArea));

    public Ironmantis(){
        textArea.setEditable(false);
        textArea.append("Operating system: "+System.getProperty("os.name")+"\n");
        textArea.append("Operating System version: " +System.getProperty("os.version")+"\n");
        textArea.append("Operating system architecture: "+ System.getProperty("os.arch")+"\n");
        textArea.append("Java version: "+ System.getProperty("java.version")+"\n");
        textArea.append("Java vendor: "+ System.getProperty("java.vendor")+"\n");
        textArea.append("Java vendor URL: "+ System.getProperty("java.vendor.url")+"\n");
        upperPanel.setPreferredSize(new Dimension(800,400));
        upperPanel.setBackground(Color.CYAN);
        splitPane.setPreferredSize(new Dimension(800,600));
        add(splitPane);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                Ironmantis i = new Ironmantis();
                i.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                i.pack();
                i.setVisible(true);
            }
        });

    }

}