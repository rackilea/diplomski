private static abstract class MyListener implements ActionListener {

    @Override
    final public void actionPerformed(ActionEvent evt) {
        theSameTask();
        uniqueTask(evt);
    } 
    private void theSameTask() {
        // the identical task
    }
    public abstract void uniqueTask(ActionEvent evt);
}