public static Picture grayAndFlipLeftToRight( Picture pic)
{
    int[][] pixels = pic.getGrayLevels();

    for (int i = 0; i < pixels.length; i++) {
        for (int curr = 0; curr < (pixels[0].length + 1) / 2; curr++) {

            int saved = pixels[i][curr];
            pixels[i][curr] = pixels[i][pixels[0].length - 1 - curr];
            pixels[i][pixels[0].length - 1 - curr] = saved;
        }
    }

    return new Picture(pixels);
}

public static Picture grayAndRotate90( Picture pic)
{
    int[][] pixels = pic.getGrayLevels(); 

    int[][] rotate = new int[pixels[0].length][pixels.length];

    for (int i = 0; i < pixels[0].length; i++) {
        for (int j = 0; j < pixels.length; j++) {
            rotate[i][pixels.length - 1 - j] = pixels[j][i];
        }
    }
    return new Picture(rotate); 
}