public Void doInBackground() {
        Random random = new Random();
        int progress = 0;
        //Initialize progress property.
        setProgress(0);
        while (progress < 100) {
            //Sleep for up to one second.
            try {
                //original code: Thread.sleep(random.nextInt(1000));
                Thread.sleep(10);
            } catch (InterruptedException ignore) {}
            //Make random progress.
            //originalcode: progress += random.nextInt(10);
            progress++;
            setProgress(Math.min(progress, 100));
        }
        return null;
    }