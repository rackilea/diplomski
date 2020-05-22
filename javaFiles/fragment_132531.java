import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class GuiInterface {

    private JFileChooser ourFileSelector = new JFileChooser();
    private JList list = new JList(new DefaultListModel());

    public GuiInterface() {
        Action openAction = new AbstractAction("Open Subtitle") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ourFileSelector.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                ourFileSelector.showSaveDialog(null);
                File ourSrtFile = ourFileSelector.getSelectedFile();
                String srtPath = ourSrtFile.getAbsolutePath();
                ArrayList<String> array = ReadFile.getFileStartingTime(srtPath);
                DefaultListModel model = (DefaultListModel) list.getModel();
                for (String s : array) {
                    model.addElement(s);
                }
            }
        };
        JButton button = new JButton(openAction);
        JFrame frame = new JFrame();
        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(200, 300));
        frame.add(scroll);
        frame.add(button, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] aregs) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GuiInterface();
            }

        });
    }
}

class ReadFile {

    public static ArrayList<String> getFileStartingTime(String path) {
        ArrayList<String> Lines = new ArrayList<String>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));

            String line;

            while ((line = br.readLine()) != null) {
                Lines.add(line);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }

        return Lines;
    }
}