public void propertyChange(PropertyChangeEvent evt) {
    if ("progress" == evt.getPropertyName() ) {
        int progress = (Integer) evt.getNewValue();
        progressMonitor.setProgress(progress);

        //  Added this

        AccessibleContext ac = progressMonitor.getAccessibleContext();
        JDialog dialog = (JDialog)ac.getAccessibleParent();
        java.util.List<JButton> components =
            SwingUtils.getDescendantsOfType(JButton.class, dialog, true);
        JButton button = components.get(0);
        button.setVisible(false);

        // end of change

        String message =
            String.format("Completed %d%%.\n", progress);
        progressMonitor.setNote(message);
        taskOutput.append(message);
        if (progressMonitor.isCanceled() || task.isDone()) {
            Toolkit.getDefaultToolkit().beep();
            if (progressMonitor.isCanceled()) {
                task.cancel(true);
                taskOutput.append("Task canceled.\n");
            } else {
                taskOutput.append("Task completed.\n");
            }
            startButton.setEnabled(true);
        }
    }
}