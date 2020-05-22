SwingWorker<Void, String> worker = new SwingWorker<Void, String>(){

        @Override
        protected Void doInBackground() throws Exception {
            this.publish("Everything");
            Thread.sleep(1000);
            this.publish("Everything is");
            Thread.sleep(1000);
            this.publish("Everything is Awesome!");
            return null;
        }

        @Override
        protected void process(List<String> res){
            for(String text : res){
                 label.setText(text); 
            }
        }

    };

    worker.execute();