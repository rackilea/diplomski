LinearLayout.LayoutParams boxParams = new LinearLayout.LayoutParams(
    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
box.setLayoutParams(boxParams);
box.setText(R.string.cheese);

// if you want checkbox change listener
box.setOnCheckedChangedListener(new OnCheckedChangedListener(){
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (isChecked){
            // perform logic
        }
    }
};

// if you want on click listener functionality
box.setOnClickListener(new OnClickListener(){
    @Override
    public void onClick(View v){
        // perform logic
    }
}

linearLayout.addView(box);