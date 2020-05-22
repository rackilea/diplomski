public static void deleteDir(Context ctx) {

        try {
            File myFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                                + File.separator
                                + "MyFolder");
            }
            if (myFile.exists()) {
                deleteRecursive(myFile);
            }
        }catch (Exception ignored){
            Log.e("Delete error File: %s",ignored.getMessage());
        }
    }

    private static void deleteRecursive(File myFile) {
        if (myFile.isDirectory())
            for (File child : myFile.listFiles())
                deleteRecursive(child);
        Log.e("MyFolder Files Deleted!!! : %s", myFile.delete());
    }