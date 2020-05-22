public String toString() {
    // If your not too bothered about formatting, you can do it in a single line.
    // return Arrays.deepToString(_pixels);
    String pixelSet="";
    for(int i=0; i<_pixels.length;i++){
        for(int j=0 ;j<_pixels[i].length;j++){
            pixelSet+=this._pixels[i][j].toString();
        }
        pixelSet +="\n";
    }
    return pixelSet;
}