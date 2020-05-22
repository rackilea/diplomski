ScrollView scrollView = new ScrollView(this);
    HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this);
    LinearLayout linearLayout = new LinearLayout(this);

    horizontalScrollView.addView(linearLayout);

    scrollView.addView(horizontalScrollView);

    setContentView(scrollView);