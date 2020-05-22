extern "C"
__global__ void skintone(uchar4* data, int w, int h, int* output)
{
    int x = threadIdx.x+blockIdx.x*blockDim.x;
    int y = threadIdx.y+blockIdx.y*blockDim.y;

if (x < w && y < h)
{
    float b, g, r;
    float cb, cr;

    int index = y*w+x;
    uchar4 pixel = data[index];

    b = (float)pixel.x;
    g = (float)pixel.y;
    r = (float)pixel.z;

    cb = 128 + (-0.169f * r) - (0.331f * g) + (0.5f * b);
    cr = 128 + (0.5f * r) - (0.419f * g) - (0.081f * b);


    if((cb >= 80 &&  cb <= 120) && (cr >= 133 &&  cr <= 173)) {
        atomicAdd(&output[0], 1);
    }
}
}