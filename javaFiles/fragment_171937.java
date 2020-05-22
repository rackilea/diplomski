ImageView pngimage = (ImageView) findViewById(R.id.pngpreview );

ImageButton imgbtn = (ImageButton)findViewById(R.id.img1);
        imgbtn .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          //you already have bitmap
           pngimage.setImageBitmap(myBitmap);
          pngimage.setVisibity(View.Visible);
            }
        });