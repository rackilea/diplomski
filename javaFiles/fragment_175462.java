if (imgs.size() < 3) {
            String uriStr = imageCursor.getString(0);
            Uri uri = null;
            if (uriStr == null)
                continue;
            try {
                uri = Uri.parse(uriStr);
            } catch (Exception e) {
                // log exception
            }
            if (uri == null)
                continue;
            Bitmap bm = null;
            try {
                bm =
                        MediaStore.Images.Media.getBitmap(activity
                                .getContentResolver(), uri);
            } catch (IOException e) {
                // log exception
            }
            if (bm == null)
                continue;
            imgs.add(bm);
            if (imgs.size() == 3)
                break;
        }