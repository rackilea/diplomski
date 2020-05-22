if(result == RESULT_OK && data != null)
{
    Bitmap mCurrentSelectedBitmap;
    if(requestCode == SELECT_PICTURE)
    {
        Uri selectedimage = data.getData();
        if(selectedimage == null)
        {
            selectedimage = getTempFile();
        }
        ......
        ......
        mCurrentSelectedBitmap = decodeFile(file);
    }
    else if(requestCode == TAKE_PICTURE)
    {
        Bundle extras = data.getExtras();
        mCurrentSelectedBitmap = (Bitmap) extras.get("data");
    }
    .......
    .......
    //Do your thing
}