ANativeWindow_setBuffersGeometry(window, srcWidth, srcHeight, WINDOW_FORMAT_RGBA_8888);
if (int32_t err = ANativeWindow_lock(window, &buffer, NULL)) {
    LOGE("ANativeWindow_lock failed with error code: %d\n", err);
    ANativeWindow_release(window);
}

//convert YUV_420_888 to RGBA_888 and display
uint8_t * outPtr = reinterpret_cast<uint8_t *>(buffer.bits);
for (size_t y = 0; y < srcHeight; y++)
{
    uint8_t * Y_rowPtr = srcYPtr + y * Y_rowStride;
    uint8_t * UV_rowPtr = srcUPtr + (y >> 1) * Y_rowStride;
    // uint8_t * V_rowPtr = srcVPtr + (y >> 1) * Y_rowStride / 4;
    for (size_t x = 0; x < srcWidth; x++)
    {
        uint8_t Y = Y_rowPtr[x];
        size_t uIndex = x & 0xfffffffe;
        uint8_t U = UV_rowPtr[uIndex];
        uint8_t V = UV_rowPtr[uIndex + 1];
        double R = ((Y-16) * 1.164 + (V-128) * 1.596);
        double G = ((Y-16) * 1.164 - (U-128) * 0.392 - (V-128) * 0.813);
        double B = ((Y-16) * 1.164 + (U-128) * 2.017);
        *(outPtr++) = (uint8_t) (R > 255 ? 255 : (R < 0 ? 0 : R));
        *(outPtr++) = (uint8_t) (G > 255 ? 255 : (G < 0 ? 0 : G));
        *(outPtr++) = (uint8_t) (B > 255 ? 255 : (B < 0 ? 0 : B));
        *(outPtr++) = NUM_255; // gamma for RGBA_8888
    }
}