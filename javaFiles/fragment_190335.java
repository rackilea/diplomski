try {
                    // setting the image in the actionbar
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().getDisplayOptions()
                            | ActionBar.DISPLAY_SHOW_CUSTOM);
                    CircleImageView imageView = new CircleImageView(getSupportActionBar().getThemedContext());

LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(70, 70);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setImageBitmap(bitmap);
                    getSupportActionBar().setCustomView(imageView);
                    // setting the image in actionbar ends here
     } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }