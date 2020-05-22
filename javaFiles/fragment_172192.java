for(int r = 0; r < height; r++)
        for(int c = 0; c < width; c++)
        {
            rotatedShape[r][c] = shape[c][height-1-r];
            tempLayout += rotatedShape[r][c];

        }
}