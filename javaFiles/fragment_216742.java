{

        FileAlterationMonitor monitor = new FileAlterationMonitor();
        Iterator<FileAlterationObserver> iterator = monitor.getObservers().iterator();

        FileAlterationObserver last = null;
        while (iterator.hasNext()) {
            last = iterator.next();
        }

        final CountDownLatch cdl = new CountDownLatch(1);

        monitor.removeObserver(last);
        monitor.addObserver(new FileAlterationObserver(last.getDirectory(), last.getFileFilter()) {

            @Override
            public void initialize() throws Exception {
                super.initialize();
                cdl.countDown();
            }
        });

        try {
            // wait until last observer would be initialized
            monitor.start();
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }