public void sendString(String data) throws IOException, InterruptedException {
    String ahkPath = "C:\\Program Files\\AutoHotkey\\AutoHotkey.exe";
    String scriptPath = "C:\\Users\\MCL\\test.ahk";
    runtime.exec(new String[] { ahkPath, scriptPath, data} );
    Thread.currentThread();
    Thread.sleep(1000);
}