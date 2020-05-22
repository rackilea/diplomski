final File inFile = this.resolveLocalFileSystemURI(options.getString("fileUri"));
if (!inFile.exists()) {
    Log.d(TAG, "input file does not exist");
    callback.error("input video does not exist.");
    return;
}

final File inFile2 = this.resolveLocalFileSystemURI(options.getString("fileUri2"));
if (!inFile2.exists()) {
    Log.d(TAG, "input file2 does not exist");
    callback.error("input video2 does not exist.");
    return;
}

final String videoSrcPath = inFile.getAbsolutePath();
final String videoSrcPath2 = inFile2.getAbsolutePath();