String state = Environment.getExternalStorageState();
if(Environment.MEDIA_MOUNTED.equals(state))
{

  // Read / Write Access
  externalStorageAvailable = true;
  externalStorageWriteable = true;

}
else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state))
{

  // Read Access
  externalStorageAvailable = true;
  externalStorageWriteable = false;

}
else
{

  // We cannot read / write
  externalStorageAvailable = false;
  externalStorageWriteable = false;

}