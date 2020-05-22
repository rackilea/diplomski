public void actionPerformed(ActionEvent arg0) {
       SwingWorker<Object,Object> sw = new SwingWorker<Object,Object>()
       {
            @Override
            protected Object doInBackground() throws Exception
            {
                try {
                     Thread.sleep(2500);
                 } catch (InterruptedException e) {
                     Thread.currentThread().interrupt();
                     e.printStackTrace();
                 }
                 return null;
            }
        };
        sw.execute();
}