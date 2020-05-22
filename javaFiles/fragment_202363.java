private SwingWorker worker;
// ...
stopButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (worker != null && !worker.isCanceled()) {
            worker.cancel(true);
        }
    }
});