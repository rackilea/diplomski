Image1.setOnClickListener(new View.OnClickListener() {

    public void onClick(View v) {
        Log.d("DisplayImage", "on click");
        DisplayOneImage doi=new DisplayOneImage(DisplayImage.this,"Filtered image 1");
        doi.show();
        v.setOnClickListener(null);//Remove setOnClickListener
    }
});