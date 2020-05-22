PImage set_colorkey (PImage img, color colorkey) {
  PImage new_img = img.get();
  new_img.loadPixels();
  for (int i = 0; i < new_img.width*new_img.height; i++) {
    if (new_img.pixels[i] == colorkey) {
      new_img.pixels[i] = color(255, 1);
    }
  }
  new_img.updatePixels();
  return new_img;
}

void setup() {
  background(255, 0, 0);
  PImage img = loadImage("img.png");
  img = set_colorkey(img, color(255));
  image(img, 0, 0);
}