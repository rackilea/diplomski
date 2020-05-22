import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class TitleExample {

    private static void createAndShowGui() {
        SedimentPanel sedimentPanel = new SedimentPanel();
        PanelTitle panelTitle = new PanelTitle(sedimentPanel); // pass in the reference
        JMenuItem menuItem = new JMenuItem("SEDIMENT");
        menuItem.addActionListener(panelTitle);
        JMenu jMenu = new JMenu("Menu");
        jMenu.add(menuItem);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(jMenu);

        JFrame frame = new JFrame("TitleExample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(sedimentPanel);
        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}