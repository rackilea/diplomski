import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TestGUI extends JPanel {

    TestGUI() {
        JFrame appletFrame = new JFrame("Settings.serverName");
        appletFrame.setLayout(new BorderLayout());
        appletFrame.setDefaultCloseOperation(3);

        JPanel appletPanel = new JPanel(new BorderLayout());

        appletPanel.add(this);
        appletPanel.setPreferredSize(new Dimension(767, 537));
        appletFrame.getContentPane().add(appletPanel, BorderLayout.CENTER);

        // Don't use a menu-bar as a tool-bar!
        JToolBar jmenubar = new JToolBar();
        appletPanel.add(jmenubar, BorderLayout.PAGE_START);
        JButton Button1 = new JButton("Vote");
        JButton Button2 = new JButton("Item List");
        JButton Button3 = new JButton("Screenshot");
        JButton Button4 = new JButton("wrench");
        JButton Button5 = new JButton("keyboard");
        Button4.setBorder(null);
        Button4.setBorderPainted(false);
        Button4.setContentAreaFilled(false);
        Button5.setBorder(null);
        Button5.setBorderPainted(false);
        Button5.setContentAreaFilled(false);
        jmenubar.setLayout(new FlowLayout());
        jmenubar.add(Button1);
        jmenubar.add(Button2);
        jmenubar.add(Button3);
        jmenubar.add(Button4);
        jmenubar.add(Button5);

        JTextArea textArea = new JTextArea("TEST", 4, 65 );
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setVisible(true);
        JScrollPane scroll = new JScrollPane (
            textArea,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        appletPanel.add(scroll, BorderLayout.PAGE_END);

        appletFrame.pack();
        appletFrame.setLocationByPlatform(true);
        appletFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                new TestGUI();
            }
        });
    }
}