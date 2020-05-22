public Server(Worker worker) {
            this.clients = new ArrayList<ClientHandle>();
            this.worker = new Worker(); // <------THIS SHOULD BE this.worker = worker;
            try {
                    this.start();
            } catch (IOException e) {
                    Log.e("An error occurred when trying to start the server.", e,
                                    this.getClass());
            }
    }