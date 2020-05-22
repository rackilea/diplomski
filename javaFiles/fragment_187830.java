field.addPropertyChangeListener(new PropertyChangeListener() {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LOG.info("" + evt);
        if ("editValid".equals(evt.getPropertyName()) 
            &&  Boolean.FALSE.equals(evt.getNewValue())) {
          SpinnerNumberModel model = (SpinnerNumberModel) spin2.getModel();  
          JOptionPane.showMessageDialog(null,
          "Error: Number must be in range [" + model.getMinimum() + " ..." + model.getMaximum() + "]",
           "Error Massage",
          JOptionPane.ERROR_MESSAGE);

        }

    }
});