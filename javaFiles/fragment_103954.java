public void createButtons() {
    while(i<34)
    {
        Button btnTag = new Button(this);
        btnTag.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        btnTag.setText(names[i]);
        btnTag.setId(i);
        btnTag.setTag("TAG"+i); // set a tag
        btnTag.callOnClick();
        layout.addView(btnTag);
        btnTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
        i++;
    }
}

// hand button click
public void buttonClicked(View view) {
    final Object tag = view.getTag();
    if ("TAG1".equals(tag)) {
        //button 1
    } else if ("TAG2".equals(tag)) {
        //button 2
    }
    // add more if else
}