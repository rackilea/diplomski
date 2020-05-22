public Game() {
    addComponentListener(new ComponentAdapter() {
        private boolean initalised = false;
        private Timer timer = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initalised = true;
                panel.init();
                timer.stop();
            }
        });

        @Override
        public void componentResized(ComponentEvent e) {
            if (!initalised) {
                timer.restart();
            }
        }
    });