protected void onActivityResult(int requestCode, int resultCode, Intent data) 
{
    if (resultCode == RESULT_OK && requestCode == SDCARD_ROOT_CODE)
    {
        // Persist access permissions
        Uri sdcdardRootUri = data.getData();
        grantUriPermission(getPackageName(), sdcdardRootUri, Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        final int takeFlags = data.getFlags() & (Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        getContentResolver().takePersistableUriPermission(sdcdardRootUri, takeFlags);

        // Do whatever you want with sdcdardRootUri
    }
}