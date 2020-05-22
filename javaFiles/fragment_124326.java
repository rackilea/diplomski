// ** no need to queue this on the event thread.
     // ** we're already IN the event thread!
     recognitionProgress.setString("Marking ROI...");

     bmt.addPropertyChangeListener(new PropertyChangeListener() {

        @Override
        public void propertyChange(PropertyChangeEvent pcEvt) {
           if (pcEvt.getPropertyName().equals("state")) {
              if (pcEvt.getNewValue().equals(SwingWorker.StateValue.DONE)) {
                 // you'd probably have this in a method.
                 RecognitionTask rt = new RecognitionTask();
                 rt.addPropertyChangeListener(PrismRunnable.this);

                 // ** no need to queue this on the event thread.
                 // ** we're already IN the event thread!
                 recognitionProgress.setString("Segmenting...");

                 rt.execute();
              }