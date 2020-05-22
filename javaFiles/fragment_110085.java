private File getAbsoluteFile(String relativePath, Context context) {
    if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
        return new File(context.getExternalFilesDir(null), relativePath);
    } else {
        return new File(context.getFilesDir(), relativePath);
    }
}