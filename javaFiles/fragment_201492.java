public void saveFile(String filepath, String filename) {
    AccessController.doPrivileged(new PrivilegedAction() {
        public Object run() {
            File theDir = new File(filepath);
            try {
                if (theDir.exists()) { // This throws exception
                    win.call("appletMsg", new Object[] { "Directory Exists", "win" });
                } else {
                    win.call("appletMsg", new Object[] { "Creating Directory...", "msg" });
                    if (theDir.mkdir()) {
                        win.call("appletMsg", new Object[] { "Directory Created", "win" });
                    } else
                        win.call("appletMsg", new Object[] { "Directory Creation Failed!", "fail" });
                }
            } catch (Exception e) { // This exception is caught
                win.call("appletMsg", new Object[] { "Error Reading Directory!", "fail" });
                win.call("appletMsg", new Object[] { filepath, "fail" });
            }
            // More code for working with files, error happens above this
        }
    });
}