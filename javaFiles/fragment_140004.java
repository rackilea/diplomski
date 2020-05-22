void setup() {

    size(200, 200);
    source = loadImage("C:/temp/flower.jpg"); //source = loadImage("sunflower.jpg"); 
    destination = createImage(source.width, source.height, RGB);
    destination.copy(source, 0, 0, source.width, source.height, 0, 0, source.width, source.height);
}

void draw() {

    // [...]

    image(destination, 0, 0);
}