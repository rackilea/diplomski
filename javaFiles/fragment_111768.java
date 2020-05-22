if (info.equalsIgnoreCase("new")) { // UNCHANGED

        Bitmap background = BitmapFactory.decodeResource(
                getApplicationContext().getResources(), 
                android.R.drawable.ic_dialog_alert //<<<< Use a stock Android image for testing
        ); //Kullanıcı resim seçerkenki aşama
        selectedImage = background; //<<<< ADDED to overcome null pointer exception
        imageView.setImageBitmap(background); //<<<< UNCHANGED
        //........ rest of the code