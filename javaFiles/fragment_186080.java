Bitmap bitmap = BitmapFactory.decodeFile(Environment
                .getExternalStorageDirectory()
                + File.separator
                + "Pictures/" + IMAGE_FILE_NAME);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
        byte[] byte_arr = stream.toByteArray();

        ByteArrayBody fileBody = new ByteArrayBody(byte_arr,
                "imageFileName.jpg");

        MultipartEntity multipartEntity = new MultipartEntity(
                HttpMultipartMode.BROWSER_COMPATIBLE);

        multipartEntity.addPart("file", fileBody);

        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = null;
            try {

                HttpPost httppost = new HttpPost(url);
                httppost.setEntity(multipartEntity);
                response = httpclient.execute(httppost);


               } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage(), e);
            }