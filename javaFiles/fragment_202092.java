@Override
public void actionPerformed(ActionEvent ae) { // some action event
    final String someString = "SoMe StRiNg"; // some String

    SwingWorker<Void, Void> task = new SwingWorker<Void, Void>() {
        @Override
        public Void doInBackground() {
            writeFileLC(someString.toCharArray());
            return (Void)null;
        }
        @Override
        public void done() {
            try {
                get();
            } catch(Exception e) {
                e.printStackTrace(System.err);
            }
        }
    };

    task.execute();
}