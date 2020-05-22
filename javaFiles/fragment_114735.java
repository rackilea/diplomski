Test.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            ExecutorService es = Executors.newCachedThreadPool();
            es.submit(new Runnable() {
                @Override
                public void run() {
                    int x = 0;
                    while (x < 500) {
                        x++;
                    }
                }
            });
        }
 });