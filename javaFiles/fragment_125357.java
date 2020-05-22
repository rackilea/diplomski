public class CopyWorker extends SwingWorker {

    private File source;
    private File dest;
    private Component parent;

    private ProgressMonitorInputStream pmis;

    public CopyWorker(Component parent, File source, File dest) {
        this.parent = parent;
        this.source = source;
        this.dest = dest;
    }

    @Override
    protected Object doInBackground() throws Exception {
        try (InputStream is = new FileInputStream(source)) {
            try (OutputStream os = new FileOutputStream(dest)) {
                pmis = new ProgressMonitorInputStream(
                        parent,
                        "Copying...",
                        is);

                pmis.getProgressMonitor().setMillisToPopup(10);

                byte[] buffer = new byte[2048];
                int nRead = 0;

                while ((nRead = pmis.read(buffer)) != -1) {
                    os.write(buffer, 0, nRead);
                }
            }
        }
        return null;
    }

    @Override
    protected void done() {
        try {
            pmis.close();
        } catch (Exception e) {
        }
    }

}