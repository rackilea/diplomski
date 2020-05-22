private static double round (double value, int precision,boolean up) {
int scale = (int) Math.pow(10, precision);
if(up){
    return (double) Math.ceil(value * scale) / scale;
}else{
   return (double) Math.floor(value * scale) / scale;
}