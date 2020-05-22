btnSearch.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            new Thread("Fetcher") {

                boolean running = true;

                public void run() {
                    running = true;

                    while (running) {
                        SwingUtilities.invokeLater(() -> exportField.setText("Searching..."));
                        try {
                            exportField.setText(crawler.fetchHtml(url));
                        } catch (Exception e) {
                            SwingUtilities.invokeLater(() -> exportField.setText("invalid parameters."));
                            e.printStackTrace();
                        }
                        try {
                            Thread.sleep(60000);
                        } catch (InterruptedException e) {

                            e.printStackTrace();
                        }
                    }
                }
            }.start();              
        }
    });