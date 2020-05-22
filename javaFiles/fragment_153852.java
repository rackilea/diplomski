LayoutInflater inflater = (LayoutInflater)this.getSystemService
              (Context.LAYOUT_INFLATER_SERVICE);


    LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.testlayout, null);
    Button btn = (Button)linearLayout.findViewById(R.id.button1);
    btn.setText("Hello");

    RelativeLayout rl=findViewById(R.id.root);
    rl.addView(linearLayout);