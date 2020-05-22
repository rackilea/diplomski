//Nav Header Section
//Here I am using glide you can use picasso
    View header = navigationView.getHeaderView(0);
    navImageView = header.findViewById(R.id.nav_ImageView);
    navTextView = header.findViewById(R.id.nav_Textview);
    navTextView.setText(sharedPreferences.getString("name", ""));
    Log.d("success121", String.valueOf(navTextView));
    navText = sharedPreferences.getString("logo",null);
    if(navText!=null) {
        Log.e("Photo Url: ", navText);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_launcher_background);
        requestOptions.error(R.drawable.ic_launcher_foreground);

        Glide.with(this).load(navText)
                .apply(requestOptions).thumbnail(0.5f).into(navImageView);

    }