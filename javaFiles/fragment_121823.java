btnCount.setOnClickListener(new OnClickListener() {
    public void onClick(View V) {
        ImageView image = findViewById(...); // ... is the id of ImageView
        count++; 
        if (count > 500) count = 0;
        if (count > 100) image.setDrawable(...); // 100~200
        if (count > 200) image.setDrawable(...); // 200~300
        // ... and then 300~400 and 400~500
        txtCount.setText(String.valueOf(count));
        mpButtonClick.start(); 
    }
});