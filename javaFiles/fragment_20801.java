private class ButtonAction extends AbstractAction {
  public ButtonAction(String name) {
     super(name);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
     final MyWorker myWorker = new MyWorker();
     myWorker.addPropertyChangeListener(new PropertyChangeListener() {

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
           if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
              try {
                 int result = myWorker.get().intValue();
                 if (result != 0) {
                    TestB.startGUI2();
                    System.out.println("gui1 null? " + (TestB.getGUI1() == null));
                    System.out.println("frame null? " + (frame == null));

                    TestB.getGUI1().frame.dispose();
                 }                     
              } catch (InterruptedException | ExecutionException e) {
                 e.printStackTrace();
              }
           }
        }
     });
     myWorker.execute();
  }
}

private class MyWorker extends SwingWorker<Integer, Void> {
  @Override
  protected Integer doInBackground() throws Exception {
     int result = 0;
     Scanner read = null;
     try {
        read = new Scanner(new File(USER_FILE_PATH));
        result = read.nextInt();
     } catch (FileNotFoundException ex) {
        Logger.getLogger(GUI1B.class.getName()).log(Level.SEVERE, null, ex);
     } finally {
        if (read != null) {
           read.close();
        }
     }
     return result;
  }
}