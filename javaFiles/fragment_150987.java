for (Iterator<File> iterator = Arrays.asList(scores).iterator(); iterator.hasNext();) {
     final File file = iterator.next();
     new Thread(new Runnable() {
        public void run() {
           new de().commit(file);
        }
     }).start();  
  }