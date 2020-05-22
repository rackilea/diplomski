String image = ii.getStringExtra("image");
File imgFile = new  File(image);

    if(imgFile.exists()){

        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

        ImageView myImage = (ImageView) findViewById(R.id.imageviewTest);

        myImage.setImageBitmap(myBitmap);

    }