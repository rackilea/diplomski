ParseCloud.callFunctionInBackground("getPicture", params,
    new FunctionCallback<String>() {
        @Override
        public void done(String object,
                ParseException e) {

            byte[] imgBytes = Base64.decode(object, Base64.DEFAULT);
            if (imgBytes.length > 0) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(imgBytes, 0, imgBytes.length);
                ((ImageView) findViewById(R.id.image_view)).setImageBitmap(bitmap); 
            }
        }

    }
);