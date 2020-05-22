for(int j = 0; j < adjWidth-2; j++) {
    int index = (adjWidth*i + j) * 3;
    int b = iData[index];
    int g = iData[index+1];
    int r = iData[index+2];
    ...
    image.setRGB(j, this.height-i-1, rgb);
}