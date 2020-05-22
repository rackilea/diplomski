ImageView iv = currentView.ivMainCard;
        iv.layout(0,0,0,0);

        String url = currentCard.getImageUrl();

        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.progress_animation)
                .crossFade()
                .into(iv);