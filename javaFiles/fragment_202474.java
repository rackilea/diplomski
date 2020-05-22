int pixels[] = new int[values.length*3];
for(int i = 0; i<values.length; i++){
   pixels[3*i] = (values[i]>>16)&0xff;
   pixels[3*i+1] = (values[i]>>8)&0xff;
   pixels[3*i+2] = (values[i])&0xff;
}