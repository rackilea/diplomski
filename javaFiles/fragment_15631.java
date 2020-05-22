myChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
myChooser.addPropertyChangeListener(new PropertyChangeListener() {
  public void propertyChange(PropertyChangeEvent evt) {
        if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(evt.getPropertyName())) {
            File file = (File) evt.getNewValue();
            if (file != null && file.isFile()) {    // your condition                  
                myChooser.setControlButtonsAreShown(false);
            }
            else if ( file != null ) {
                System.out.println(file.getName());
                myChooser.setControlButtonsAreShown(true);
            }
        }

        myChooser.repaint();
    }
});