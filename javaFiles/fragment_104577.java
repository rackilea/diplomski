Runtime runTime = Runtime.getRuntime();
try {
    Process process = runTime.exec("C:\\Program Files\\Windows Media Player\\wmplayer.exe /play /fullscreen C:\\56775-download.mp4");
} catch (IOException e) {
    e.printStackTrace();
}