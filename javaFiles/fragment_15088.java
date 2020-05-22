public class UI {

    public static File selectFile() {

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("MS Excel Files", "xlsx");
        chooser.setFileFilter(filter);
        chooser.showOpenDialog(null);

        return chooser.getSelectedFile();
    }