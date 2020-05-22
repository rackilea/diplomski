private const int MAX_BLACK_VALUE = 382; // ((255 * 3) / 2) rounded down

private bool CheckForSignature(string SignatureFile, int MinPixelCount)
{
    using (Bitmap bitmap = new Bitmap(SignatureFile))
    {
        int nBytesPerPixel = Bitmap.GetPixelFormatSize(bitmap.PixelFormat) / 8;
        System.Drawing.Imaging.BitmapData bitmapData = bitmap.LockBits(new Rectangle(0, 0, bitmap.Width, bitmap.Height), System.Drawing.Imaging.ImageLockMode.ReadOnly, bitmap.PixelFormat);
        try
        {
            byte[] baPixels = new byte[bitmapData.Stride * bitmap.Height];
            System.Runtime.InteropServices.Marshal.Copy(bitmapData.Scan0, baPixels, 0, baPixels.Length);

            int nBlackPixels = 0;
            for (int h = 0; h < bitmap.Height; h++)
            {
                int nCurrentLine = h * bitmapData.Stride;
                for (int w = 0; w < (bitmap.Width * nBytesPerPixel); w += nBytesPerPixel)
                {
                    int nBlue = baPixels[nCurrentLine + w];
                    int nGreen = baPixels[nCurrentLine + w + 1];
                    int nRed = baPixels[nCurrentLine + w + 2];

                    if (nBlue + nGreen + nRed <= MAX_BLACK_VALUE)
                    {
                        nBlackPixels++;
                        if (nBlackPixels >= MinPixelCount)
                            return true;
                    }
                }
            }
        }
        finally
        {
            bitmap.UnlockBits(bitmapData);
        }
    }

    return false;
}