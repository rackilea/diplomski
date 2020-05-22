gallery.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                selectedImagePosition = pos;

                if (selectedImagePosition > 0 && selectedImagePosition < drawables.size() - 1) {

                    leftArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_left_enabled));
                    rightArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_right_enabled));

                } else if (selectedImagePosition == 0) {

                    leftArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_left_disabled));

                } else if (selectedImagePosition == drawables.size() - 1) {

                    rightArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_right_disabled));
                }

                changeBorderForSelectedImage(selectedImagePosition);
                setSelectedImage(selectedImagePosition);

selectedImageView .setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
              WallpaperManager myWallpaperManager
             = WallpaperManager.getInstance(getApplicationContext());
            try {
             Bitmap bitmap=((BitmapDrawable)selectedImageView .getDrawable()).getBitmap();
             if(bitmap!=null)
             myWallpaperManager.setBitmap(bitmap);
            } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
            }
            }
        });
            }