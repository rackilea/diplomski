ImageView imageView = (ImageView)myContentsView.findViewById(R.id.ivRowImage);
 if (not_first_time_showing_info_window) {
     Picasso.with(getApplicationContext()).load("YOUR_IMG_URL").into(imageView);
 } else { // if it's the first time, load the image with the callback set
     not_first_time_showing_info_window=true;
     Picasso.with(getApplicationContext()).load("YOUR_IMG_URL").into(imageView,new InfoWindowRefresher(marker));
 }