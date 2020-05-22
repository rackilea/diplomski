int microSecond = 6000000;// 6th second as an example
RequestOptions options = new RequestOptions().frame(microSecond).override(50, 50);

Glide.with(getApplicationContext())
        .asBitmap()
        .load(videoUri)
        .apply(options)
        .into(yourImageView);