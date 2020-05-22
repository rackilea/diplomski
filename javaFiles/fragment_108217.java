Task<T> backgroundTask = new Task<T>() {
        @Override
        protected T call() throws Exception {
            return null;
        }

        @Override
        public void run() {
            try {
                    copyFile(source,destination); //or any other operation you want to have in a thread.
                        } catch (IOException e) {
                           e.printStackTrace();
                        }
                }
        }
    };
    Thread backgroundThread = new Thread(backgroundTask);
    backgroundThread.setDaemon(true); //true if you want to have it running excuslivly when having your parent-threat running