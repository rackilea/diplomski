private Activity mActivity;
        public NewsAdapter(ArrayList < News > news, Activity mActivity) {
            this.news = news;
            this.mActivity = mActivity;
        }

        if (news.getImagePath() != null) {
            Picasso.with(mActivity).load(news.getImagePath()).centerCrop().into(viewHolder.slika);
        } else {
            Picasso.with(mActivity).load(news.getImagePath()).centerCrop().placeHolder("placeholder").into(viewHolder.slika);

        }