View v=inflater.inflate(R.layout.fourth_layout, container, false);
    Button myButton=(Button)v.findViewById(R.id.button2);
    myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
    buttona1(view)
    });
return v;