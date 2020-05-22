// intro
final File inFile = this.resolveLocalFileSystemURI(options.getString("fileUri"));
if (!inFile.exists()) {
    Log.d(TAG, "input file does not exist");
    callback.error("input video does not exist.");
    return;
}

// recording
final File inFile2 = this.resolveLocalFileSystemURI(options.getString("fileUri2"));
if (!inFile2.exists()) {
    Log.d(TAG, "input file2 does not exist");
    callback.error("input video2 does not exist.");
    return;
}

// outro
final File inFile3 = this.resolveLocalFileSystemURI(options.getString("fileUri3"));
if (!inFile3.exists()) {
    Log.d(TAG, "input file3 does not exist");
    callback.error("input video3 does not exist.");
    return;
}

// overlay
final File inFile4 = this.resolveLocalFileSystemURI(options.getString("fileUri4"));
if (!inFile4.exists()) {
    Log.d(TAG, "input file4 does not exist");
    callback.error("input video4 does not exist.");
    return;
}

final String videoSrcPath = inFile.getAbsolutePath();
final String videoSrcPath2 = inFile2.getAbsolutePath();
final String videoSrcPath3 = inFile3.getAbsolutePath();
final String videoSrcPath4 = inFile4.getAbsolutePath();