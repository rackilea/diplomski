import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JFileChooser fc;
        private JList<File> listOfFiles;
        private JLabel selectedFile;

        public TestPane() {
            setLayout(new BorderLayout());
            JButton browse = new JButton("Browse");
            browse.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (fc == null) {
                        fc = new JFileChooser();
                        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    }
                    int returnVal = fc.showOpenDialog(fc);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File directory = fc.getSelectedFile();
                        File[] filesInDir = directory.getAbsoluteFile().listFiles();
                        addFilesToList(filesInDir);
                    }
                }

                protected void addFilesToList(File[] filesInDir) {
                    DefaultListModel<File> model = (DefaultListModel<File>) listOfFiles.getModel();
                    model.removeAllElements();
                    for (File file : filesInDir) {
                        model.addElement(file);
                    }
                }
            });
            add(browse, BorderLayout.NORTH);

            listOfFiles = new JList<>(new DefaultListModel<File>());
            listOfFiles.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        File file = listOfFiles.getSelectedValue();
                        selectedFile.setText("You selected: " + (file == null ? "Nothing" : file.getPath()));
                    }
                }
            });
            add(new JScrollPane(listOfFiles));

            selectedFile = new JLabel("You selected: Nothing");
            add(selectedFile, BorderLayout.SOUTH);

        }

    }

}