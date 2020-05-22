SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        tfFIXMsg.append( inputLine + "\n\n\n");
        // or whatever swing action you want to perform...
    }
});