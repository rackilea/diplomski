for (size_t y = 0; y < srcHeight; y++)
{
    uint8_t * Y_rowPtr = srcYPtr + y * Y_rowStride;
    uint8_t * U_rowPtr = srcUPtr + (y >> 1) * Y_rowStride / 2;
    uint8_t * V_rowPtr = srcVPtr + (y >> 1) * Y_rowStride / 2;
    for (size_t x = 0; x < srcWidth; x++)
    {
        uint8_t Y = Y_rowPtr[x];
        uint8_t U = U_rowPtr[(x >> 1)];
        uint8_t V = V_rowPtr[(x >> 1)];
        double R = ((Y-16) * 1.164 + (V-128) * 1.596);
        double G = ((Y-16) * 1.164 - (U-128) * 0.392 - (V-128) * 0.813);
        double B = ((Y-16) * 1.164 + (U-128) * 2.017);
        *(outPtr++) = (uint8_t) (R > 255 ? 255 : (R < 0 ? 0 : R));
        *(outPtr++) = (uint8_t) (G > 255 ? 255 : (G < 0 ? 0 : G));
        *(outPtr++) = (uint8_t) (B > 255 ? 255 : (B < 0 ? 0 : B));
        *(outPtr++) = NUM_255; // gamma for RGBA_8888
    }
}