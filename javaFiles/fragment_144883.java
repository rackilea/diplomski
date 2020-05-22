uint8_t* bitmapPixel;
if ((AndroidBitmap_lockPixels(env, bitmap, (void **)&bitmapPixel)) < 0){
    __android_log_print(ANDROID_LOG_INFO, "bitmap-processing", "Bitmap type error");
    return NULL;
}

struct pixel { uint8_t r, g, b, a; };
uint32_t num_transparent = 0;
for (int y = 0; y < info->height; y++) {
    pixel* row = (pixel *)(bitmapPixel + y * info->stride);
    for (int x = 0; x < info->width; x++) {
        const pixel& p = row[x];
        if (p.a == 0)
            num_transparent++;
    }
}

float proportion_transparent = float(num_transparent) / (info->width * info->height);