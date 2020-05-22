imageView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    imgView = imageView;
                    boolean hasPermission = (ContextCompat.checkSelfPermission(ImagePagerActivity.this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
                    if (!hasPermission) {
                        ActivityCompat.requestPermissions(ImagePagerActivity.this,
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                112);
                    }else
                    {
                        showDialog();
                    }


                }
            });