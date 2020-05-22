class TaskRun extends Task<Void> {

    @Override
    protected Void call() {
        for (int i = 0; i < 100; i++) {
            // do stuff...
            updateProgress(i, 100);
        }
        return null ;
    }

}