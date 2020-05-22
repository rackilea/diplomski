double a;
while (!word.equals("quit")) {
  a = in.nextDouble();
  if (word.equals("triangle")) {
    s = new Shapet(a, in.nextDouble());
  } else if (word.equals("rectangle")) {
    s = new Shaper(a, in.nextDouble());
  } else if (word.equals("square")) {
    s = new Shapes(a);
  }
  // ...
}