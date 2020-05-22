class Y {
  static int g;
}

Y y1 = new Y();
Y y2 = new Y();
y1.g = 5;
y2.g = 10;
// y1.g is 10, because y1.g and y2.g mean the exact same thing