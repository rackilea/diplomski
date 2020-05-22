Glide.with(this)
            .load(imageGif)
            .asGif()
            .fitCenter()
            .crossFade()
            .into(imageView);