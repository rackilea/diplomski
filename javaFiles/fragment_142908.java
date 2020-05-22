String url="https://c.apple.news/AgEXQU9SSmFycEhYUUVlSkxKUE52XzN1M1EAMA";

    RequestOptions requestOptions = new RequestOptions();
    requestOptions.error(R.drawable.img_placeholder);
    Glide.with(context)
            .setDefaultRequestOptions(requestOptions)
            .load(url)
            .into(imgImage);