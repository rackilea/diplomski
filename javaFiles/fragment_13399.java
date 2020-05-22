public void rollover() {
    synchronized (lock) {
        // Note: This method needs to be synchronized because it needs exclusive
        // access while it closes and then re-opens the target file.
        //
        // make sure to close the hereto active log file! Renaming under windows
        // does not work for open files
        this.closeOutputStream();

        try {
            rollingPolicy.rollover(); // this actually does the renaming of files
        } catch (RolloverFailure rf) {
            addWarn("RolloverFailure occurred. Deferring roll-over.");
            // we failed to roll-over, let us not truncate and risk data loss
            this.append = true;
        }

        try {
            // update the currentlyActiveFile           
            currentlyActiveFile = new File(rollingPolicy.getActiveFileName());

            // This will also close the file. This is OK since multiple
            // close operations are safe.
            // COMMENT MINE this also sets the new OutputStream for the new file
            this.openFile(rollingPolicy.getActiveFileName()); 
        } catch (IOException e) {
            addError("setFile(" + fileName + ", false) call failed.", e);
        }
    }
}