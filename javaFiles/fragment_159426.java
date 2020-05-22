public static final String DB_PATH = "/data/data/" + "com.your.package.name" + "/databases/";

private void copyFromAssetsAndCreateDatabase() {
    InputStream yourDatabaseFromAsset;

    try {
        yourDatabaseFromAsset = getApplicationContext().getAssets().open("MyExternalDatabase1");

        File dir = new File(DataHelper.DB_PATH);
        if (!dir.exists()) dir.mkdir();
        File f = new File(DataHelper.DB_PATH + "MyExternalDatabase1" + ".sqlite");
        if (!f.exists()) {
            f.createNewFile();
        }

        OutputStream mOutput = new FileOutputStream(f);
        byte[] mBuffer = new byte[1024];
        int mLength;

        while ((mLength = yourDatabaseFromAsset.read(mBuffer)) > 0)
            mOutput.write(mBuffer, 0, mLength);

        mOutput.flush();
        mOutput.close();
        mInputEnglish.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}