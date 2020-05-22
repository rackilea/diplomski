float[][] kernel = new float[size][size];
int mean = size / 2;
float sum = 0; // For accumulating the kernel values
for (int x = 0; x < size; x++)  {
    for (int y = 0; y < size; y++) {
        kernel[x][y] = (float) (Math.exp(-0.5 * (Math.pow((x - mean) / sigma, 2.0) + 
                Math.pow((y - mean) / sigma, 2.0))) / (2 * Geometry.PI * sigma * sigma));
        // Accumulate the kernel values
        sum += kernel[x][y];
    }
}

// Normalize the kernel
for (int x = 0; x < size; x++) 
    for (int y = 0; y < size; y++)
        kernel[x][y] /= sum;