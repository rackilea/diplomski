JFileChooser chooser = new JFileChooser();

// Add listener on chooser to detect changes to selected file
chooser.addPropertyChangeListener(new PropertyChangeListener() {
    public void propertyChange(PropertyChangeEvent evt) {
        if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY
                .equals(evt.getPropertyName())) {
            JFileChooser chooser = (JFileChooser)evt.getSource();
            File oldFile = (File)evt.getOldValue();
            File newFile = (File)evt.getNewValue();

            // The selected file should always be the same as newFile
            File curFile = chooser.getSelectedFile();
        } else if (JFileChooser.SELECTED_FILES_CHANGED_PROPERTY.equals(
                evt.getPropertyName())) {
            JFileChooser chooser = (JFileChooser)evt.getSource();
            File[] oldFiles = (File[])evt.getOldValue();
            File[] newFiles = (File[])evt.getNewValue();

            // Get list of selected files
            // The selected files should always be the same as newFiles
            File[] files = chooser.getSelectedFiles();
        }
    }
}) ;