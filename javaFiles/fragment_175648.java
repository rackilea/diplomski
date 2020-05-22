LayoutInflater loiViewInflater = (LayoutInflater) getSystemService (Context.LAYOUT_INFLATER_SERVICE);

        View mView = loiViewInflater.inflate(R.layout.activity_main, null);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,400,0,0);

        addContentView(mView, params);