yuv[0] = new uint8_t[lumaPlaneSize];
yuv[1] = new uint8_t[lumaPlaneSize/4];
yuv[2] = new uint8_t[lumaPlaneSize/4];

int inLinesize[1] = { 3*nvEncoder->width }; // RGB stride
int outLinesize[3] = { 3*width ,3*width ,3*width }; // YUV stride
//                     ^^^^^^^  ^^^^^^^  ^^^^^^^