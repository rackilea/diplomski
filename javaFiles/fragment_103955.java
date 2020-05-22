public void createButtons() {
    // just need one listener object
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buttonClicked(v);
        }
    };
    while(i<34)
    {
        Button btnTag = new Button(this);
        btnTag.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        btnTag.setText(names[i]);
        btnTag.setId(i);
        btnTag.setTag("TAG"+i); // set a tag
        btnTag.callOnClick();
        layout.addView(btnTag);
        btnTag.setOnClickListener(listener);
        i++;
    }
}