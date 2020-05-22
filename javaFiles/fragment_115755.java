private void buttonFragmentActionPerformed(java.awt.event.ActionEvent evt) {
  try {
     ESIPlusFragmenterWorker epfw = new ESIPlusFragmenterWorker(10,
           sdfFile, cidSpectrum);
     epfw.addPropertyChangeListener(new PropertyChangeListener() {

        @Override
        public void propertyChange(PropertyChangeEvent pcEvt) {
           if ("state".equals(pcEvt.getPropertyName())) {
              if (pcEvt.getNewValue().equals(SwingWorker.StateValue.DONE)) {
                 holder.molTable1.drawMolViewPanel(currDir + sep
                       + "esiFragments" + sep + "esiFrag.sdf");
              }
           }
        }
     });
     epfw.execute();