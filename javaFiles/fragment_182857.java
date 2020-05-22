bool imagesAreEqual(Image i1, Image i2)
{
    if (i1.getHeight() != i2.getHeight()) return false;
    if (i1.getWidth() != i2.getWidth()) return false;

    for (int y = 0; y < i1.getHeight(); ++y)
       for (int x = 0; x < i1.getWidth(); ++x)
            if (i1.getPixel(x, y) != i2.getPixel(x, y)) return false;

    return true;
}