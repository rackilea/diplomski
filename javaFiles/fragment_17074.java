LoadingPane loadingPane = new LoadingPane();
JFrame frame = new JFrame("Testing");
frame.setGlassPane(loadingPane);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(new JLabel("I'll wait here okay"));
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);

NotesLoader loader = new NotesLoader() {
    @Override
    protected void process(List<Properties> chunks) {
        System.out.println(chunks.size() + " notes were loaded");
        // Update you model??
    }
};
loader.addPropertyChangeListener(new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String name = evt.getPropertyName();
        switch (name) {
            case "state":
                switch (loader.getState()) {
                    case STARTED:
                        frame.getGlassPane().setVisible(true);
                        frame.getGlassPane().requestFocusInWindow();
                        break;
                    case DONE:
                        frame.getGlassPane().setVisible(false);
                        try {
                            // Doubt your need the list, but it's good to do this
                            // incase there was an exception which occured during
                            // the running of the worker
                            List<Properties> notes = loader.get();
                        } catch (InterruptedException | ExecutionException ex) {
                            ex.printStackTrace();
                            // Maybe show an error message...
                        }
                        break;
                }
                break;
            case "progress":
                // I like working with normalised values :P
                loadingPane.setProgress(((int)evt.getNewValue() / 100f));
                break;
        }
    }
});