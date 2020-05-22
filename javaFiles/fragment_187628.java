ActionBar mActionBar = getActionBar();
    mActionBar.setDisplayShowHomeEnabled(false);
    mActionBar.setDisplayShowTitleEnabled(false);
    LayoutInflater mInflater = LayoutInflater.from(this);

    View mCustomView = mInflater.inflate(R.layout.badge_layout_cartCounter, null);

    mActionBar.setCustomView(mCustomView);
    mActionBar.setDisplayShowCustomEnabled(true);