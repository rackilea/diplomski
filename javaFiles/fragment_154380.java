....
    public ProgressBarDemo() {
        setContentPane(progressBar);
        setPreferredSize(new Dimension(100, 100));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();

        new SwingWorker<Integer,Integer>() {
            public Integer doInBackground() { 
                while (progressCounter <= 100) {
                    publish(progressCounter++);
                    try { Thread.sleep(500); } catch (InterruptedException e) {}                    
                }
                return 0;
            }
            public void process(List<Integer> progresses) {
                Integer maxProgress = null;
                for (int progress : progresses) {
                    if (maxProgress == null || progress > maxProgress) {
                        maxProgress = progress;
                    }
                }
                progressBar.setValue(maxProgress);
            }
        }.execute();
    }
    ....