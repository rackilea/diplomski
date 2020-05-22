Bitmap bitmap = someFunctionReturningABitmap();
long redBucket = 0;
long greenBucket = 0;
long blueBucket = 0;
long pixelCount = 0;

for (int y = 0; y < bitmap.getHeight(); y++)
{
    for (int x = 0; x < bitmap.getWidth(); x++)
    {
        Color c = bitmap.getPixel(x, y);

        pixelCount++;
        redBucket += Color.red(c);
        greenBucket += Color.green(c);
        blueBucket += Color.blue(c);
        // does alpha matter?
    }
}

Color averageColor = Color.rgb(redBucket / pixelCount,
                                greenBucket / pixelCount,
                                blueBucket / pixelCount);