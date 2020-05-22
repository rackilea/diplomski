if (turn == white) {
     try {
        final SwingWorker<Move, Void> mySwingWorker = new SwingWorker<Move, Void>() {
           @Override
           protected Move doInBackground() throws Exception {
              Engine e = new Engine(); // Engine is implemented by runnable
              e.start();
              Move m = e.getBestMove(board);                  
              return m;
           }
        };

        mySwingWorker.addPropertyChangeListener(new PropertyChangeListener() {
           public void propertyChange(PropertyChangeEvent evt) {
              if (StateValue.DONE == mySwingWorker.getState()) {
                 try {
                    Move m = mySwingWorker.get();

                    // TODO: insert code to run on the EDT after move determined

                 } catch (InterruptedException e) {
                    e.printStackTrace();
                 } catch (ExecutionException e) {
                    e.printStackTrace();
                 }
              }
           }
        });
        mySwingWorker.execute();

     } catch (Exception e) {
        e.printStackTrace();
     }
  }