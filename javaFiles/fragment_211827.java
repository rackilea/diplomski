private void setUpCustomUpNavigation() {
        LayoutInflater mLayoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View customUpNavView = mLayoutInflater.inflate(R.layout.up_navigation_layout, null);

        // "ic_ab_back_holo_light.png" Located in ...android-sdk\platforms\android-14\data\res\drawable-xhdpi
        ImageView backArrowImageView = (ImageView) customUpNavView.findViewById(R.id.backArrowImageView);

        ImageView logoToolbarImageView = (ImageView) customUpNavView.findViewById(R.id.logoToolbarImageView);

        TextView titleTextView = (TextView) customUpNavView.findViewById(R.id.titleTextView);


        // set logo
        logoToolbarImageView.setImageResource(R.drawable.help_toolbar_ic_selector);

        // set title
        titleTextView.setText(R.string.title_activity_help);

        mToolbar.addView(customUpNavView);
    }