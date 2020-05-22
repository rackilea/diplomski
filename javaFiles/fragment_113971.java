//Copy the database from assets
private void copyDataBase() throws IOException
{
    InputStream mInput = mContext.getAssets().open(DB_NAME);
    String outFileName = DB_PATH + DB_NAME;

    OutputStream mOutput = new FileOutputStream(outFileName);
    byte[] mBuffer = new byte[1024];
    int mLength;
    while ((mLength = mInput.read(mBuffer))>0)
    {
        mOutput.write(mBuffer, 0, mLength);
    }
    mOutput.flush();
    mOutput.close();
    mInput.close();
}