private URI getTempFile()
    {
        if (isExternalStorageWritable())
        {
            File file = new File(Environment.getExternalStorageDirectory(), "temporary_file.jpg");
            try
            {
                if(!file.exists())
                {
                    file.createNewFile();
                }
            } catch (IOException e)
            {
            }
            return Uri.fromFile(file);
        } else
        {
            return null;
        }
    }

public void DoShowSelectImage(View v) {
    Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    i.putExtra(MediaStore.EXTRA_OUTPUT, getTempFile());
    startActivityForResult(i, SELECT_PICTURE);
}