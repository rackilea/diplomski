public interface ProgressMonitor {
    /**
     * Passes the progress of between 0-1
     */
    public void progressUpdated(double progress);
}