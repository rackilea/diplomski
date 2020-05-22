JFileChooser fc = new JFileChooser();
int returnVal = fc.showSaveDialog(null);
//select and enter a name for a file under libraries (with windows look and feel 
//select 'desktop' in the left pane, then libraries->pictures)
if (returnVal == JFileChooser.APPROVE_OPTION) {
    File file = fc.getSelectedFile();
    FileWriter fw = new FileWriter(file); //<-- FileNotFoundException
    fw.write("foo bar");
    fw.close();
}