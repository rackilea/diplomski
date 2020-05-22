int videoId = videoCursor.getInt(videoCursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID));
        Cursor videoThumbnailCursor =getContentResolver().query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI,
                thumbColumns, MediaStore.Video.Thumbnails.VIDEO_ID+ "=" + videoId, null, null);

        if (videoThumbnailCursor.moveToFirst())
        {
            String thumbPath = videoThumbnailCursor.getString(videoThumbnailCursor.getColumnIndex(MediaStore.Video.Thumbnails.DATA));
            Log.i("ThumbPath: ",thumbPath);
            thumbImage.setImageURI(Uri.parse(thumbPath));
        }

        return listItemRow;