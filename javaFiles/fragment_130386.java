#pragma version(1)
#pragma rs java_package_name(za.co.overtake)

int*reds;
int*greens;    
int*blues;
int imgWidth;

uchar4 RS_KERNEL root(uchar4 in, uint32_t x, uint32_t y) {
   bool colourme = false;
   for(int col = 0; col < imgWidth; col++){

        const int red = reds[col];
        const int green = greens[col];
        const int blue = blues[col];

         if (in.r == red && in.g == green && in.b == blue){
            colourme = true;
        } 
    }
     if (colourme) {
        in.r = 255;
        in.g = 0;
        in.b = 0;
        in.a = 50;
     } else {
         in.r = 0;
         in.g = 0;
         in.b = 0;
         in.a = 0;
     }
    return in;
}