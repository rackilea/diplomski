// data class
public class MyOpenFilesBean {

    private File currentFile; 

    public void setCurrentFile(File current) {
         File old = getCurrentFile();
         this.currentFile = current;
         firePropertyChange("currentFile", old, getCurrentFile());
    }

    public File getCurrentFile() {
        return currentFile;
    }

}  

// view wiring (view --> data)

Action open = new AbstractAction(...) {

      public void actionPerformed(...) {
          File choosenFile = // grab it from whereever in the view
          myOpenFileBean.setCurrentFile(choosenFile);
      }  

};
myButton.setAction(open);
myComboBox.setAction(open);

// view wiring (data --> view)

PropertyChangeListener l = new PropertyChangeListener() {
     public void propertyChanged(...) {
         if ("currentFile".equals(evt.getPropertyName()) {
               // a method implemented to update f.i. the combo selection  
               updateView((File) evt.getNewValue());
         }
     } 
};
myOpenFileBean.addPropertyChangeListener(l);