button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {                                          
        button.setEnabled(false); // change text if you want
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Do the calculations
                // Wait if you want
                Thread.sleep(1000);
                // Dont touch the UI
                return null;
            }
            @Override
            protected void done() {
                try {
                    get();
                } catch (Exception ignore) {
                } finally {
                    button.setEnabled(true); // restore the text if needed
                }
            }                    
        }.execute();
    }
});