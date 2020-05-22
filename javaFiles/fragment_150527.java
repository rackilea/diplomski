button.setOnClickListener(new OnClickListener() 
                {

                    @Override
                    public void onClick(View v) {

                         WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                         try {
                            wallpaperManager.setResource(imageIDs[curruntPosition]);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(getApplicationContext(), 
                                "Image is clicked-"+v.getBackground(), Toast.LENGTH_SHORT).show();

                    }
                });