private void loadImages(String url){
    Picasso.with(context)
        .load(url)
        .placeholder(R.drawable.user_placeholder)
        .error(R.drawable.user_placeholder_error)
        .into(imageView);
    }