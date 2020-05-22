import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ComboDemo extends JFrame implements ActionListener {

    private String rootDir;
    private JComboBox box1;
    private JComboBox box2;

    /**
     * Create the frame.
     */
    public ComboDemo () {
        super("Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createGui();
        this.rootDir = "/home";
        setRootDir(new File(this.rootDir));
    }

    /**
     * Create the gui components.
     */
    private void createGui () {
        this.box1 = new JComboBox();
        this.box2 = new JComboBox();
        this.box1.addActionListener(this);
        this.box2.addActionListener(this);

        this.box1.insertItemAt("Choose directory :", 0);
        this.box1.setSelectedIndex(0);
        this.box2.insertItemAt("Choose subdirectory :", 0);
        this.box2.setSelectedIndex(0);

        setLayout(new FlowLayout(FlowLayout.LEADING));
        add(this.box1);
        add(this.box2);
    }

    /**
     * Show the gui.
     */
    private void showGui () {
        setSize(500, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Update the first selector with the directories listed under the specified
     * root directory.
     * 
     * @param dir
     *            Root directory.
     */
    private void setRootDir (File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                this.box1.addItem(file.getName());
            }
        }
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() instanceof JComboBox) {
            JComboBox box = (JComboBox) e.getSource();

            // Box 1
            if (this.box1.equals(box)) {
                String dirName = box.getSelectedItem().toString();
                // RootDir / Folder
                File dir = new File(this.rootDir + File.separator + dirName);
                System.out.println("# Folder : " + dir.getPath());

                // Check if there is a least one file
                if (dir.exists() && dir.listFiles().length > 0) {
                    Arrays.sort(dir.listFiles(), Collections.reverseOrder());

                    // Reset box2
                    this.box2.removeAllItems();
                    this.box2.insertItemAt("Choose subdirectory :", 0);

                    // Update Box2
                    this.box2.removeActionListener(this);
                    for (File file : dir.listFiles()) {
                        if (file.isDirectory()) {
                            this.box2.addItem(file.getName());
                        }
                    }
                    this.box2.addActionListener(this);
                    this.box2.setSelectedIndex(0);
                }
            }
            // Box 2
            else if (this.box2.equals(box)) {
                // Check if box2 is empty
                if (box.getItemCount() > 0) {
                    String dirName = box.getSelectedItem().toString();
                    // RootDir / Folder / SubFolder
                    File dir = new File(this.rootDir + File.separator + this.box1.getSelectedItem().toString()
                            + File.separator + dirName);
                    System.out.println("# SubFolder : " + dir.getPath());

                    // Check if there is a least one file
                    if (dir.exists() && dir.listFiles().length > 0) {
                        Arrays.sort(dir.listFiles(), Collections.reverseOrder());

                        // Print .txt files
                        for (File file : dir.listFiles()) {
                            if (file.isFile() && file.getName().endsWith(".txt")) {
                                System.out.println("\t" + file.getName());
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main (String[] args) {
        ComboDemo demo = new ComboDemo();
        demo.showGui();
    }
}