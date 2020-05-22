favourite_image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(imageChange ){
                            favourite_image.setImageResource(R.drawable.ic_heart);
                            favourite_image.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            imageChange = false;                        
                           }else {
                                favourite_image.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                                favourite_image.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                imageChange = true;
                            }
                        }
                    });