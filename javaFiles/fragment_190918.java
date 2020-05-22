public void actionPerformed(ActionEvent event) {
    textArea.setText("");

    SwingWorker<String, Object> worker = new SwingWorker<String, Object>() {
        @Override
        protected String doInBackground() throws Exception {                
            return ...; // call a REST API
        }
        @Override
        protected void done() {
            try {
                textArea.setText(get());
            } catch (Exception e) {
                //ignore
            }
        }
    };      
    worker.execute();
}