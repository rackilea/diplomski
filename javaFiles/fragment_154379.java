....
    public ProgressBarDemo() {
        setContentPane(progressBar);
        setPreferredSize(new Dimension(100, 100));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();

        SwingWorker<Integer, Void> worker = new SwingWorker<Integer,Void>() {
            public Integer doInBackground() {
                while (progressCounter <= 100) {
                    setProgress(progressCounter++);
                    try { Thread.sleep(500); } catch (InterruptedException e) {}
                }
                return 0;
            }
        };
        worker.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent event) {
                if ("progress".equals(event.getPropertyName())) {
                    progressBar.setValue((Integer)event.getNewValue());
                }
            }
        });
        worker.execute();
    }
    ....