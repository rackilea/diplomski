private static final int threashold = 10;

void findDifference(Bitmap firstImage, Bitmap secondImage)
{
    if (firstImage.getHeight() != secondImage.getHeight() || firstImage.getWidth() != secondImage.getWidth())
        Toast.makeText(this, "Images size are not same", Toast.LENGTH_LONG).show();

    boolean isSame = true;

    for (int i = 0; i < firstImage.getWidth(); i++)
    {
        for (int j = 0; j < firstImage.getHeight(); j++)
        {
            int pixel = firstImage.getPixel(i,j);
            int redValue = Color.red(pixel);
            int blueValue = Color.blue(pixel);
            int greenValue = Color.green(pixel);

            int pixel2 = secondImage.getPixel(i,j);
            int redValue2 = Color.red(pixel2);
            int blueValue2 = Color.blue(pixel2);
            int greenValue2 = Color.green(pixel2);

            if (Math.abs(redValue2 - redValue) + Math.abs(blueValue2 - blueValue) + Math.abs(greenValue2 - greenValue) <= threashold)
//                if (firstImage.getPixel(i,j) == secondImage.getPixel(i,j))
            {
            }
            else
            {
                differentPixels.add(new Pixel(i,j));
                secondImage.setPixel(i,j, Color.YELLOW); //for now just changing difference to yello color
                isSame = false;
            }
        }
    }
    imgOutput.setImageBitmap(secondImage);
}