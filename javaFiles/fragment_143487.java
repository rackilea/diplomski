for(int h = 0; h < height; h++){
        for(int w = 0; w < width; w++){
            mirrorTemp[h][w] = pixels[h][w];
            mirrorTemp[h][w + width] = pixels[h][width - w];
        }
    }