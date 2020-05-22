// I get the files on the directory I'm writing and the amount of files + 1
File f = new File(myDirectory.toString());        
File file[] = f.listFiles();
int fileNumber = file.length+1;

// START THE RECORDER
recorder = new MediaRecorder();
recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
recorder.setOutputFile(
    String.format(Locale.US, "%s%crecord-%08d.3pg",
        myDirectory, File.separatorChar, fileNumber));
try {
    recorder.prepare();
} catch(IOException e) {
    Log.e(TAG, "error while preparing recording", e);
    // You might want to inform the user too, with a Toast
    return;
}
recorder.start();