public void doLongRunningThing() {
    final JProgressBar bar = ....; // this comes from somewhere, maybe you create it or look it up.

    Thread workerThread = new Thread( new Runnable() {
        public void run() {
           try {
              for( int i = 0; i < words.length; i++ ) {
                  doSomeWorkOn( words[i] );
                  final int progress = i; // have to handle Java-ism
                  SwingUtilities.invokeLater( new Runnable() {
                     public void run() {
                         bar.setProgress( progress );
                     }
                  });
              }
           } finally {
              SwingUtilities.invokeLater( new Runnable() {
                 public void run() {
                     // todo clean up the UI like hide the dialog or hide progress bar, etc.
                 }
              });
           }
       }
    } );
    worker.start();
}