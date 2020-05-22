// EMPTY - value of backgroung e.g. white for the sample image
PixelType curPixel = EMPTY;
int y = height - 1; // last row, the one we added
for (int x = 0; x < width; ++x)
{
    // img(y,x) - current pixel, is "empty"
    // img (y-1, x) - pixel above the current
    if (img(y-1, x) != img(y, x))
    {
        // pixel above isn't empty, so we make current pixel non-empty
        img(y, x) = img(y-1, x);
        // if we were drawing, then stop, otherwise - start
        if (curPixel == EMPTY)
            curPixel = img(y-1, x);
        else
            curPixel = EMPTY;
    }
    else
    {
        img(y, x) = curPixel; 
    }
}