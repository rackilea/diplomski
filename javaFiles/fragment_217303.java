cursor = mContext.getContentResolver().query(TvContractCompat.Channels.CONTENT_URI,
                Channel.PROJECTION,
                null,
                null,
                null);
 if (cursor != null && cursor.moveToFirst()) {
                Log.i(TAG,cursor.getCount()+"Chaines ont étaient mise à jour avec Succés");
                do {
                    channels.add(Channel.fromCursor(cursor));

                }while (cursor.moveToNext());