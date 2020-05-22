View injecterLayout;


    LinearLayout myLayout = (LinearLayout)findViewById(R.id.linearLayout2);
    injecterLayout = getLayoutInflater().inflate(R.layout.newplayerlayout, myLayout, false);
    myLayout.addView(injecterLayout);

    injecterLayout = getLayoutInflater().inflate(R.layout.newplayerlayout, myLayout, false);
    myLayout.addView(injecterLayout);

    injecterLayout = getLayoutInflater().inflate(R.layout.newplayerlayout, myLayout, false);
    myLayout.addView(injecterLayout);