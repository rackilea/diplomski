RequestOptions requestOptions = new RequestOptions();
 requestOptions.placeholder(R.drawable.placeholder_card_view);
 requestOptions.error(R.drawable.placeholder_card_view);


  Glide.with(getContext())
       .load(path)
       .apply(requestOptions)
       .thumbnail(Glide.with(getContext()).load(path))
       .into(ivVideoThumbnail);