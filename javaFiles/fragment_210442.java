private void deleteExternalStoragePrivateFile() {
    File path = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
    if (path != null) {

        if (path.isDirectory()) {
            for (File child : path.listFiles()) {
                String child1 = child.toString();
                if (child1.contains("OneRepublic_-_Something_I_Need.mp3")) {
                    child.delete();
                }
                if (child.isDirectory()) {
                    Toast.makeText(getApplicationContext(), "Not Deleted", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "File Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}