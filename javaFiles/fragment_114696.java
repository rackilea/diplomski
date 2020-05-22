public class FileChooser {
public String getFile(){
    //public static void main(String[] args){
    JFileChooser fc=new JFileChooser();
    fc.setDialogTitle("Excel File For Updating Columns");
    fc.setApproveButtonText("Choose Excel File");
     FileNameExtensionFilter filter = new FileNameExtensionFilter("XLS files", "xls");
      int returnVal=fc.showOpenDialog(null);
      if (returnVal == JFileChooser.APPROVE_OPTION) {
        return fc.getSelectedFile().getAbsolutePath();
      }
     else return null;
    }
    public static void main(String[] args) {
        new FileChooser().getFile();
    }
}