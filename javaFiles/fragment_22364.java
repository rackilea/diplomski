public void setModel(final SimpleModel simpleModel) {
  this.simpleModel = simpleModel;
  simpleModel.addPropertyChangeListener(new PropertyChangeListener() {

     @Override
     public void propertyChange(PropertyChangeEvent evt) {
        if (SimpleModel.FILE_TEXT.equals(evt.getPropertyName())) {
           txtArea.append("File Text: " + simpleModel.getFileText() + "\n");
        }
     }
  });
}