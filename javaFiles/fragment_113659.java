String text = "";
String cursor = "_";

boolean blink = true;

void setup() {
  size(500, 500);
}

void draw() {

  if(frameCount % 30 == 0){
    blink = !blink;
  }

  background(0);

  if(blink){
    text(text, 100, 100, 200, 200);
  }
  else{
    text(text+cursor, 100, 100, 200, 200);
  }
}

void keyPressed()
{
  if (key == BACKSPACE)
  {
    if (text.length() > 0) {
      text = text.substring(0, text.length()-1);
    }
  } else {
    text += key;
  }
}