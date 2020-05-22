taskExecutor.execute(new Runnable() {
    @Override
    public void run() {
        try {
            int i = 1/0;
        } catch (Exception e) {
            onExceptionInTask( new MyCustomException(e) ); // <== Inform main.
        }
    }
});