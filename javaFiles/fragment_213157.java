private void dialogWaiting()
    {
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        JTextArea msgLabel;
        final JDialog dialogWaiting;
        JPanel panel;

        msgLabel = new JTextArea("Please wait...");
        msgLabel.setEditable(false);


        panel = new JPanel(new BorderLayout(5, 5));
        panel.add(msgLabel, BorderLayout.PAGE_START);
        panel.add(progressBar, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));

        dialogWaiting = new JDialog(Frame.getFrames()[0], "Doing whatever", true);
        dialogWaiting.getContentPane().add(panel);
        dialogWaiting.setResizable(false);
        dialogWaiting.pack();
        dialogWaiting.setSize(300, dialogWaiting.getHeight());
        dialogWaiting.setLocationRelativeTo(null);
        dialogWaiting.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialogWaiting.setAlwaysOnTop(true);     
        msgLabel.setBackground(panel.getBackground());

        SwingWorker worker = new SwingWorker() {

            @Override
            protected void done() {
                // Close the dialog
                dialogWaiting.dispose();
            }

            @Override
            protected Void doInBackground() {
                // Do the long running task here
                // put all the code you want to run as the dialogWaiting is on

                return null;
            }
        };

        worker.execute();
        dialogWaiting.setVisible(true);
    }