void handleSendVideo(Intent intent)
{
    // get title
    String title = intent.getExtras().getString(Intent.EXTRA_SUBJECT);

    // get the uri for the video
    mVideoUri = (Uri) intent.getExtras().get(Intent.EXTRA_STREAM);

    // check if it originates from snapchat
    if (mVideoUri.getAuthority().equals(UriHelper.SNAPCHAT_FILE_PROVIDER))
    {
        Intent mRequestFileIntent;
        ParcelFileDescriptor mInputPFD;
        mRequestFileIntent = new Intent(Intent.ACTION_PICK);
        mRequestFileIntent.setType("video/*");

        // Query the content resolver to get the name of the file. Beware that you will not find
        // the actual file here. You must read it from the fileDescriptor.
        Cursor fileDataCursor = getContentResolver().query(mVideoUri, null, null, null, null);
        String fileName = "";
        if (fileDataCursor != null)
        {
            fileDataCursor.moveToFirst();
            fileName = fileDataCursor.getString(0);
            fileDataCursor.close();
        }

        // something is wrong... return
        if (fileName.isEmpty())
        {
            return;
        }

        try {
            // open the file descriptor that belongs to the file given to us by snapchat.
            mInputPFD = getContentResolver().openFileDescriptor(mVideoUri, "r");

            // fetch the descriptor
            FileDescriptor fd = mInputPFD.getFileDescriptor();

            // create in input stream from descriptor
            InputStream inputStream = new FileInputStream(fd);

            // This is the file that will be created
            File targetFile = new File(Environment.getExternalStorageDirectory(), fileName);

            // Open a outputstream connected to the file
            FileOutputStream fileOutputStream = new FileOutputStream(targetFile);

            // Create a buffer with a size equal to what is available from the inputstream.
            // Note: we dont have to loop here because the file is available on the storage.
            byte[] buffer = new byte[inputStream.available()];

            // Read all data into the buffer
            inputStream.read(buffer);

            // Write the buffer to the outputstream
            fileOutputStream.write(buffer);

            // close all streams, our file is ready.
            inputStream.close();
            fileOutputStream.close();
            mInputPFD.close();

            // check if the new file exists.
            if (targetFile.exists())
            {
                // add the file to the android MediaProvider
                mVideoUri = addVideo(targetFile);
            }
            else
            {
                DialogMaker.showAlertMessage(this, "Could not read video", "unable to read video from SnapChat.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });

                return;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    try {
        logger.i("videoUri: " + mVideoUri.toString());
        logger.i("videoPath: " + mVideoUri.getPath());
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public Uri addVideo(File videoFile) {
    ContentValues values = new ContentValues(3);
    values.put(MediaStore.Video.Media.TITLE, "My video title");
    values.put(MediaStore.Video.Media.MIME_TYPE, "video/mp4");
    values.put(MediaStore.Video.Media.DATA, videoFile.getAbsolutePath());
    return getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, values);
}