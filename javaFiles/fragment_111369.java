int min_time = 3000; // in ms
int max_time = 8000; // in ms

int time_frame = (int)random(min_time, max_time);

int time_stamp = 0;

boolean show_door = true;

void setup()
{
  size(512, 348); //width and height of screen
}

void draw()
{
  background(200);

  int time_passed = millis() - time_stamp;

  if (time_passed < time_frame && show_door) {
    display();
  } else if (time_passed >= time_frame) {
    time_stamp = millis();
    time_frame = (int)random(min_time, max_time);
    show_door = !show_door;
  }
}

void display()
{
  fill(255);
  rect(420, 190, 55, 100); //house door outline
  fill(0, 0, 0); // fill the following polygons in black
  rect(435, 210, 25, 25, 7); // house door window
  ellipse(435, 255, 8, 8); // house door handle
}