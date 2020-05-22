PImage img, front, mask;
int xstart, ystart, xend, yend;
int ray;

void setup() {
    size(961, 534);

    img = loadImage("back.jpg");
    front = loadImage("front.jpg");
    mask = createImage(img.width, img.height, RGB);
    img.mask(mask);

    xstart = 0;
    ystart = 0;
    xend = img.width;
    yend = img.height;
    ray = 50;
}

void draw() {
    img.loadPixels();
    front.loadPixels();

    // loop over image pixels 
    for (int x = xstart; x < xend; x++) {
        for (int y = ystart; y < yend; y++ ) {
            int loc = x + y*img.width;
            float dd = dist(mouseX, mouseY, x, y);        

            if (mousePressed && dd < 50) {
                mask.pixels[loc] = color(255, 255, 255);
            }
            else {
                if (!mousePressed) {
                    //mask = createImage(img.width, img.height, RGB);
                    mask.pixels[loc] = color(0, 0, 0);
                }
            }
        }
    }
    mask.updatePixels();
    img.mask(mask);

    // show front image
    image(front, 0, 0);
    image(img, 0, 0);
}