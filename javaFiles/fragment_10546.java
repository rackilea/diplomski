public void closeDialog(){
    SwingUtitilies.invokeLater(new Runnable(){
      public void run(){
          Future<?> f = execService.submit(swingWorker);
          JOptionPane.showMessageDialog(null, "Created Future");
          f.get(120, TimeUnit.SECONDS);
      }
    });
}