LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    LinearLayout dialerLayout = (LinearLayout) layoutInflater.inflate(R.layout.phone_dialer, null);
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
    dialerLayout.setLayoutParams(params);
    LinearLayout tabDialer = (LinearLayout) findViewById(R.id.tabDialer);
    tabDialer.addView(dialerLayout);