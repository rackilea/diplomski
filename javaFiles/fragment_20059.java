public static class CustomOnSaveTask implements OnSaveTask {

    private final Context context;

    public CustomOnSaveTask(Context ctx) {
        context = ctx;
    }

    @Override
    public void performTask() {
        System.out.println(">>> Save performed on " + 
                NbEditorUtilities.getDataObject(context.getDocument()).toString());
    }

    @Override
    public void runLocked(Runnable r) {
        r.run();
    }

    @Override
    public boolean cancel() {
        return true;
    }

    @MimeRegistration(mimeType = "text/x-sieve-java", service = OnSaveTask.Factory.class, position = 1600)
    public static class CustomOnSaveTaskFactory implements OnSaveTask.Factory {

        @Override
        public OnSaveTask createTask(Context cntxt) {
            return new CustomOnSaveTask(cntxt);
        }

    }
}