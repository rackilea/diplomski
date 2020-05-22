{
    unsigned int planeSize;
    unsigned int halfWidth;

    unsigned char * yplane;
    unsigned char * uplane;
    unsigned char * vplane;
    const unsigned char * rgbIndex;

    int x, y;
    unsigned char * yline;
    unsigned char * uline;
    unsigned char * vline;

    planeSize = srcFrameWidth * srcFrameHeight;
    halfWidth = srcFrameWidth >> 1;

    // get pointers to the data
    yplane = yuv;
    uplane = yuv + planeSize;
    vplane = yuv + planeSize + (planeSize >> 2);
    rgbIndex = rgb;

        for (y = 0; y < srcFrameHeight; y++)
        {
        yline = yplane + (y * srcFrameWidth);
        uline = uplane + ((y >> 1) * halfWidth);
        vline = vplane + ((y >> 1) * halfWidth);

        if (flip)
        rgbIndex = rgb + (srcFrameWidth*(srcFrameHeight-1-y)*rgbIncrement);

            for (x = 0; x < (int) srcFrameWidth; x+=2)
            {
                rgbtoyuv(rgbIndex[0], rgbIndex[1], rgbIndex[2], *yline, *uline, *vline);
                rgbIndex += rgbIncrement;
                yline++;
                rgbtoyuv(rgbIndex[0], rgbIndex[1], rgbIndex[2], *yline, *uline, *vline);
                rgbIndex += rgbIncrement;
                yline++;
                uline++;
                vline++;
}
}
}