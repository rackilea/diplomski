package custom_file_chooser;

import java.io.File;

import javax.swing.JFileChooser;

public class MyFileChooser extends JFileChooser {

    private String filterString;

    public MyFileChooser(String filterString) {
        super();
        this.filterString = filterString;

        setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        setFileFilter(new MyFileFilter(filterString));
    }

    @Override
    public void approveSelection() {
        File file = this.getSelectedFile();
        if (!file.isDirectory() || file.getName().contains(filterString)) {
            super.approveSelection();           
        }   
    }
}