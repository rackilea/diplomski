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

    ImageView imageView = (ImageView) gallery.getSelectedView();

        imageView.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                     Handler handler = new Handler();
                 handler.postDelayed(new Runnable(){

                    @Override
                    public void run() {

                        AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(GalleryDemoActivity.this);
                         myAlertDialog.setTitle("Wallpaper");
                         myAlertDialog.setMessage("Want to set as Wallpaper?");
                         myAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                          public void onClick(DialogInterface dialog, int arg1) {
                              WallpaperManager myWallpaperManager
                                 = WallpaperManager.getInstance(getApplicationContext());
                                try {
                                 Bitmap bitmap=((BitmapDrawable)imageView.getDrawable()).getBitmap();
                                 if(bitmap!=null)
                                 myWallpaperManager.setBitmap(bitmap);
                                } catch (IOException e) {
                                 // TODO Auto-generated catch block
                                 e.printStackTrace();
                                }
                          }});
                         myAlertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                          public void onClick(DialogInterface dialog, int arg1) {
                         dialog.dismiss();
                          }});
                         myAlertDialog.create().show(); 
                    }

                 }, 3000);
                    }
                });


             }