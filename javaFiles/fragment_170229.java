class sendMessageThread implements Runnable {
    private String s = "";
    public sendMessageThread(String s) {
        this.s = s;
    }

    public void run() {
        try {
            mWriter.write(s + '\n');
            mWriter.flush();
            mHandler.post(new updateStatusThread("Befehl gesendet: \"" + s + "\"", false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}