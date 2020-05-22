float position = 0;

void setup() {
  size(800, 600);
  frameRate(100);
}

void draw() {

  position  = position < 850f ? position + 4f : 0f;

  background(#FFFFFF);
  rect(800f - position, 300f, 50f, 30f);
}