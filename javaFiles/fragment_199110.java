share.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            BitmapDrawable drawable = (BitmapDrawable) image.getDrawable();
            Bitmap bitmap = drawable.getBitmap();

            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("image/jpeg");

            ByteArrayOutputStream bytes = new ByteArrayOutputStream();

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

            String savedFile = saveImageFile(bitmap, "myFolder");

            Uri imageUri =  Uri.parse(savedFile);
            share.putExtra(Intent.EXTRA_STREAM, imageUri);
            startActivity(Intent.createChooser(share, "Share Image"));

        }
    });