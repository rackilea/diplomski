float[] kernel = new float[size];
int mean = size / 2;
float sum = 0; // For accumulating the kernel values
for (int x = 0; x < size; x++)  {
    kernel[x] = (float) Math.exp(-0.5 * Math.pow((x - mean) / sigma, 2.0));
    // Accumulate the kernel values
    sum += kernel[x];
}

// Normalize the kernel
for (int x = 0; x < size; x++) 
    kernel[x] /= sum;