LinearLayout layout = (LinearLayout)findViewById(R.id.linear1);     
    for(int i=0;i<4;i++)
    {
        imagev = new ImageView(this);
        imagev.setLayoutParams(new android.view.ViewGroup.LayoutParams(300,150));
        imagev.setMaxHeight(600);
        imagev.setMaxWidth(600);
        imagev.setTag(i);
        imagev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 switch(Integer.valueOf(v.getTag())) {
                      case 0: ...
                              break;
                      case 1: ...
                              break;
                 }
            } 
        layout.addView(imagev);
    }