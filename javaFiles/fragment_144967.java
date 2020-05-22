final String response = in.nextLine();
    EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            new Client(response);
        }
    });