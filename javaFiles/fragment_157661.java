Runnable updateLabel = new Runnable() {
       public void run() {
           label.setText("myValue");
       }
};
SwingWorker w = new MySwingWorker(updateLabel);
w.execute();