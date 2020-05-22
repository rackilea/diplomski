(new Runnable() {

        @Override
        public void run() {
            try {
                connection = new ConnectionPool("jdbc:mysql://127.0.0.0/comm", "root",
                        "pass");
            } catch (Exception e) {

            }
        }
    }).run();