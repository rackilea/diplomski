Delay _delay;

void setup() {
  _delay = new Delay(5000);
}

void draw() {
  if (_delay.expired()) {
    //do something
    _delay = new Delay(5000);
  }
}