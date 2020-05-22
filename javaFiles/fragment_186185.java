processes.add(new Callable<Void>() {
    @Override
    public Void call() throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                progressWindow.addProgress();
            }            
        });
        return null;
    }
    });
}