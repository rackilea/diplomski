//Insert it into the database
Uri uri = MediaStore.Audio.Media.getContentUriForPath(file.getAbsolutePath());
Uri newUri = main.getContentResolver().insert(uri, values);

RingtoneManager.setActualDefaultRingtoneUri(
  myActivity,
  RingtoneManager.TYPE_RINGTONE,
  newUri
);