URL aURL = new URL(url_detail_img);
String image_url = "https://"+ aURL.getHost() + aURL.getFile();
imageLoader.DisplayImage(data.getString(TAG_IMG), thumb_img);

                        Picasso.with(Detail.this)
                                .load(image_url)
                                .error(R.drawable.temp_img)
                                .into(thumb_img);