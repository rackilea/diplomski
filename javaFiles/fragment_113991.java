import java.io.File;
import javax.swing.JFileChooser;

public class MyFileChooser extends JFileChooser
{
    private static final long serialVersionUID = 1L;
    private String extension;

    public MyFileChooser(String currentDirectoryPath, String extension)
    {
        super(currentDirectoryPath);
        this.extension = extension;
    }

    @Override
    public File getSelectedFile()
    {
        File selectedFile = super.getSelectedFile();
        if(selectedFile != null && (getDialogType() == SAVE_DIALOG || getDialogType() == CUSTOM_DIALOG))
        {
            String name = selectedFile.getName();
            if(!name.contains(".")) selectedFile = new File(selectedFile.getParentFile(), name + "." + extension);
        }
        return selectedFile;
    }
}