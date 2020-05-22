package tests;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LoadingBox extends JPanel {
    private String inFiles;

    public void loadIt(){
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT FILES", "txt");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(getParent()); 
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getCurrentDirectory();
                String path = file.getPath();
                String filename = chooser.getSelectedFile().getName();
                String fullpath = path + "/" + filename;
                this.setFiles(fullpath);
            }
    }


    public String getFiles() {
        return inFiles;
    }

    public void setFiles(String inFiles) {
        this.inFiles = inFiles;
    }