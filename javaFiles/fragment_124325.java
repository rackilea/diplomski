public void actionPerformed(ActionEvent ae) {
     mainFrame.getGlassPane().setCursor(new Cursor(Cursor.WAIT_CURSOR));
     recognitionProgress.setStringPainted(true);
     BlueMarkerTask bmt = new BlueMarkerTask();
     bmt.addPropertyChangeListener(PrismRunnable.this);

     SwingUtilities.invokeLater(new Runnable() {
        public void run() {
           recognitionProgress.setString("Marking ROI...");
        }
     });

     bmt.addPropertyChangeListener(new PropertyChangeListener() {

        @Override
        public void propertyChange(PropertyChangeEvent pcEvt) {
           if (pcEvt.getPropertyName().equals("state")) {
              if (pcEvt.getNewValue().equals(SwingWorker.StateValue.DONE)) {
                 // you'd probably have this in a method.
                 RecognitionTask rt = new RecognitionTask();
                 rt.addPropertyChangeListener(PrismRunnable.this);

                 SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                       recognitionProgress.setString("Segmenting...");
                    }
                 });

                 rt.execute();
              }
           }
        }
     });

     bmt.execute();
  }