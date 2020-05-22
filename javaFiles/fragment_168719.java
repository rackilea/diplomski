@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        if (requestCode == ChooseImage && resultCode == RESULT_OK && data != null && data.getData() != null) {
            userProfileImage = data.getData();
            try {

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), userProfileImage);
                if (bitmap.getHeight() * bitmap.getRowBytes() < 50000)
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byte[] imageInByte = stream.toByteArray();
                    long bitmap_size = imageInByte.length / 1024; 
                    profile_photo.setImageBitmap(bitmap);

                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            uploaImage();
                        }
                    });


            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }