@Override
    public Object instantiateItem(final ViewGroup parent, int position) {
        final View view = LayoutInflater.from(host).inflate(R.layout.item_slide_reddit_post, parent, false);
        ButterKnife.bind(this, view);

        view.findViewById(R.id.progress_bar).setVisibility(View.GONE);

        return view;
    }