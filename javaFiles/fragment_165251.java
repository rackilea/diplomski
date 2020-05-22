private void backup(Context context) {
  File root = context.getFilesDir();
    File parent = root.getParentFile();
    File[] files = parent.listFiles();
    File[] tmp = null;
    for (File file : files) {
        if (file.isDirectory()) {
            tmp = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().contains("your_shared_preference_file_name");
                }
            });
            if (tmp != null && tmp.length == 1) {
                break;
            }
        }
    }

    File file = null;
    if (tmp.length == 1) {
        parent = tmp[0].getParentFile();
        file = new File(Environment.getExternalStorageDirectory(), "tmp.xml");
        FileInputStream fis = new FileInputStream(tmp[0]);
        FileOutputStream fos = new FileOutputStream(file);
        byte[] buffer = new byte[32768];
        int count = 0;
        while ((count = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, count);
        }
        fis.close();
        fos.flush();
        fos.close();
    }