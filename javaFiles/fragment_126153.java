final String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Slots/";
 final File file = new File(rootPath);
 file.mkdirs();
 final File sdFile = new File(file, "Profile.txt");
try {
        FileWriter fw = new FileWriter(sdFile);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("hello "+"\n");
        bw.write("5000");
        bw.close();
    } catch (IOException e) {
        Log.e("exception ",e.getMessage());
    }