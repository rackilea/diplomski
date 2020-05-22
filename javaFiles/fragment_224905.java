LayoutInflater mInflater;
    mInflater = LayoutInflater.from(this);

    //breakpoint here, check if you have the mInflater
    View layoutView = mInflater.inflate(R.layout.activity_play, null);

    //breakpoint here, check if you have the layoutView
    ImageView character = (ImageView) layoutView.findViewById(R.id.character);

    //if you get here you should be in the clear
    setContentView(layoutView);