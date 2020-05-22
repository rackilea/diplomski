private boolean songLoaderCompleted = false;
public void workDone(Callable task)
    {
        int remainingItems = pendingItems.decrementAndGet();
        MainWindow.logger.severe(">>WorkDone:" + task.getClass().getName() + ":" +remainingItems);

        if (remainingItems == 0 && songLoaderCompleted)
        {
            MainWindow.logger.severe(">Closing Latch:");
            latch.countDown();
        }
    }