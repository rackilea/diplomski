package custom_file_chooser;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class MyFileFilter extends FileFilter {

    private String filterString;

    public MyFileFilter(String filterString) {
        super();
        this.filterString = filterString;
    }

    @Override
    public boolean accept(File file) {
         return  file.isDirectory() || file.getName().toLowerCase().contains(filterString);
     }

     @Override
     public String getDescription() {
         return filterString + " only";
     }    
}