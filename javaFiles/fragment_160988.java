public Welcome()
{        
    // Set the displayed title of the screen       
    setTitle("Select a brand");

    Bitmap bitmapImage = Bitmap.getBitmapResource("Celsian.jpg");
    BitmapField fieldDemo = new BitmapField(bitmapImage);    
    add(fieldDemo);

}