Glide.with(context)
    .load(imgUrl)
    .asGif()
    .placeholder(R.drawable.img)
    .crossFade()
    .into(imageView);