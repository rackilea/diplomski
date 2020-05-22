ContentValues values = new ContentValues();
values.put(Media.TITLE, title);
values.put(Media.DESCRIPTION, description); 
values.put(Images.Media.DATE_TAKEN, System.currentTimeMillis()); // DATE HERE
values.put(Images.Media.MIME_TYPE, "image/jpeg");
values.put(MediaStore.MediaColumns.DATA, filepath);

context.getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, values);