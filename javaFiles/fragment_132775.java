Thread t = new Thread(){
   public void run(){
       processFile(selectedFile);
       // now you need to refresh the UI... it must be done in the UI thread
       // to do so use "SwingUtilities.invokeLater"
       SwingUtilities.invokeLater(new Runnable(){
          public void run(){
              loaderLabel.setText("Done..");
              missingTransactionsPanel.setVisible(true);
          }
          }
       )
   }
};
t.start();