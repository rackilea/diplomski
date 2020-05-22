int histogram[256];
for (int i=0;i<256;i++) {
     histogram[i] = 0;
}

for (int x = 0; x < a.getWidth(); x++) {
    for(int y = 0; y < a.getHeight(); y++) {
        int color = a.getRGB(x, y);

        int r = Color.red(pixel);
        int g = Color.green(pixel);
        int b = Color.blue(pixel);

        int brightness = (int) (0.2126*r + 0.7152*g + 0.0722*b);
        histogram[brightness]++;
    }
}

int allPixelsCount = a.getWidth() * a.getHeight();

// Count pixels with brightness less then 10
int darkPixelCount = 0;
for (int i=0;i<10;i++) {
    darkPixelCount += histogram[i];
}

if (darkPixelCount > allPixelCount * 0.25) // Dark picture. Play with a percentage
else // Light picture.