BufferedImage mapBI = .... // the map as BufferedImage
BufferedImage maskBI = .... // the mask as BufferedImage
BufferedImage resultBI = ... // new BufferedImage with same size as mask 

for (i=0; i< maskBI.width; i++){
    for(j=0; j< maskBI.height; j++){
        if (maskBI.pixelAt(i,j) == blackPixel){
            resultBI.setPixel(i,j,mapBI.pixelAt(i,j));
        }else{
            resultBI.setPixel(i,j,blackPixel);
        }
    }
}