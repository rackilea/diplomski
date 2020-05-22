private void processFiles(final List<File> files) {
    SwingWorker<Object, Object> scanFiles = new SwingWorker<Object, Object>(){ 
        @Override
        public Object doInBackground(){
            // do something with files
        }
    }
}