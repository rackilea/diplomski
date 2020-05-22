import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI() {
        JFrame jf = new JFrame();

        addComp(jf.getContentPane());

        jf.setVisible(true);
        jf.pack();
    }

    public static void addComp(Container pane) {
        JPanel containerPanel = new JPanel(new BorderLayout() );

        JTextArea textArea = new JTextArea("stuff");
        JScrollPane scrollPane = new JScrollPane(textArea); 
        textArea.setEditable(false);

        containerPanel.add(scrollPane);
        containerPanel.add(textArea, BorderLayout.CENTER);

        pane.add(containerPanel);
    }
}