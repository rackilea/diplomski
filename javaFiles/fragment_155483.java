final ClassAnalyzer c = new ClassAnalyzer();
Swinger task = new Swinger(c);
task.addPropertyChangeListener(new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state") && evt.getNewValue().equals(SwingWorker.StateValue.DONE)) {
            int methods = c.getNumberOfMethods();

            if(methods == 0){
                JOptionPane.showMessageDialogo(null, "methods not found");
            }
        }
    }
});
task.execute();