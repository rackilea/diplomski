import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class JavaApplication151 extends JFrame {

    private JMenuBar menu;
    private JMenu fileMenu;
    private JMenuItem showFilesMenuItem;
    private JTextArea ta;
    private JScrollPane areaPane;

    public JavaApplication151() {
        createAndShowUI();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JavaApplication151 test = new JavaApplication151();
                test.setVisible(true);
            }
        });
    }

    private void createAndShowUI() {
        setTitle("Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addComponentsToPane();
        addListeners();
        pack();
    }

    private void addComponentsToPane() {
        ta = new JTextArea(10, 10);
        areaPane = new JScrollPane(ta);
        fileMenu = new JMenu("File");
        showFilesMenuItem = new JMenuItem("Show Files");
        menu = new JMenuBar();
        fileMenu.add(showFilesMenuItem);
        menu.add(fileMenu);
        getContentPane().add(areaPane, BorderLayout.CENTER);
        getContentPane().add(menu, BorderLayout.NORTH);
    }

    private void addListeners() {
        showFilesMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                ta.setText("");//clear textarea text
                listFiles();
            }

            private void listFiles() {
                File folder = new File("C:\\Users\\Hugo Monteiro\\Documents\\NetBeansProjects\\FileImporter\\ImagensDB");
                File[] listOfFiles = folder.listFiles();
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile()) {
                        ta.append("File: " + listOfFiles[i].getName());
                    }
                }
            }
        });
    }
}