PImage source;
PImage destination;
int w = 80;
float[][] matrix_3_3_average = { 
    {1.0/9.0, 1.0/9.0, 1.0/9.0 }, 
    {1.0/9.0, 1.0/9.0, 1.0/9.0 }, 
    {1.0/9.0, 1.0/9.0, 1.0/9.0 }
};
float[][] matrix_3_3_sharpen = 
    { { -1, -1, -1 }, 
    { -1, 9, -1 }, 
    { -1, -1, -1 } };

void setup() {

    size(200, 200);
    source = loadImage("C:/temp/flower.jpg"); //source = loadImage("sunflower.jpg"); 
    destination = createImage(source.width, source.height, RGB);
    destination.copy(source, 0, 0, source.width, source.height, 0, 0, source.width, source.height);
}

boolean average = key == '0';
boolean sharpen = key == '1'; 

void keyPressed() {
    average = key == '0';
    sharpen = key == '1'; 
}

void draw() {

    int xStart = constrain(mouseX - w/2, 0, width);
    int xEnd = constrain(mouseX + w/2, 0, width);
    int yStart = constrain(mouseY - w/2, 0, height);
    int yEnd = constrain(mouseY + w/2, 0, height);
    println(xStart, xEnd, yStart, yEnd);

    if (average || sharpen) { 

        destination.copy(source, 0, 0, source.width, source.height, 0, 0, source.width, source.height);
        for (int x = 0; x < source.width; x++) {
            for (int y = 0; y < source.height; y++) {
                int loc = x + y * source.width;

                if (x > xStart && x < xEnd && y > yStart && y < yEnd) {
                    if ( average )
                        destination.pixels[loc] = convolution(x, y, matrix_3_3_average, 3, source);
                    else
                        destination.pixels[loc] = convolution(x, y, matrix_3_3_sharpen, 3, source);
                }                   
            }
        }

        source.copy(destination, 0, 0, source.width, source.height, 0, 0, source.width, source.height);
        average = sharpen = false; 
    }

    image(destination, 0, 0);
}  

color convolution(int x, int y, float[][] matrix, int matrixSize, PImage img) {
    int offset = (matrixSize - 1)/2;
    float r = 0;
    float g = 0;
    float b = 0;
    for (int i = 0; i < matrixSize; i++) {  
        for (int j = 0; j < matrixSize; j++) {
            int xLoc = x + i - offset;
            int yLoc = y + j - offset;
            int loc = xLoc + yLoc * img.width;

            loc = constrain(loc, 0, img.pixels.length-1);

            r = r + matrix[i][j] * red(img.pixels[loc]);
            g = g + matrix[i][j] * green(img.pixels[loc]);
            b = b + matrix[i][j] * blue(img.pixels[loc]);
        }
    }
    return color(r, g, b);
}