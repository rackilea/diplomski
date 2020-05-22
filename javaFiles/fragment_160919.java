for(int x = 0; x < mask.getWidth(); x++){
    for(int y = 0; y < mask.getHeight() - 1; y+=2) { // Change point 1

        g = (mask.getPixel(x,y) & 0x0000FF00) >> 8;
        r = (mask.getPixel(x,y) & 0x00FF0000) >> 16;
        b = (mask.getPixel(x,y) & 0x000000FF);

        if(Math.abs(sR-r) < ANTILAISING_TOLERANCE && Math.abs(sG-g) < ANTILAISING_TOLERANCE && Math.abs(sB-b) < ANTILAISING_TOLERANCE)
            colored.setPixel(x, y, (colored.getPixel(x, y) & 0xFFFF0000));
            colored.setPixel(x, y+1, (colored.getPixel(x, y) & 0xFFFF0000)); // Change point 2
    }
}