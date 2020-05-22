int imgWidth=1920,imgHeight=1080;
int[] row=new int[imgWidth];//for storing a line of pixels
for(int i=0;i<imgHeight;i++){
  row=img.getRGB(0,i,imgWidth,1,null,0,imgWidth);//get pixel from the current row
  for(int k=0;k<row.length;k++){
    byte[] argb=ByteBuffer.allocate(4).putInt(4).array();//break up int(color) to 4 byte (argb)
    //doing some business with pixel....
  }
    //setting the processed pixel
    //////////////////////////////////////////UPDATED!
    //Preparing each pixel using ByteBuffer class, make an int(pixel) using a 4-lenght byte array
    int rgb=ByteBuffer.wrap(new byte[]{0xff,R[x][y]&0xff,G[x][y]&0xff,B[x][y]&0xff}).getInt();
    imgnew.setRGB(x,y,rgb);//this is bettrer to buffer some pixel then set it to the image, instead of set one-by-one
    //////////////////////////////////////////
    //img.setRGB(0,i,imgWidth,1,row,0,imgWidth)
}