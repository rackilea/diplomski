SwingWorker<Void, Void> worker = new SwingWorker<Void, Void> () {
    @Override
    protected Void doInBackground() throws Exception {
        Collection<Object> objects = doSomethingIntense();
        this.myJList.clear();
        for(Object o : objects) {
            this.myJList.addElement(o);
        }
        return null;
    }
}

// This WILL THROW EXCEPTIONS because a new thread will start and meddle
// with your JList when Swing is still drawing the component
//
// ExecutorService executor = Executors.newSingleThreadExecutor();
// executor.execute(worker);

// The SwingWorker will be executed when Swing is done doing its stuff.
java.awt.EventQueue.invokeLater(worker);