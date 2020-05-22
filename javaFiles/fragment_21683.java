Random r = new Random();
String message = null;

int i = r.nextInt(100 - 90 + 1) + 90;
message = String.format("%d", i);

float f = 0.1;
message = String.format("%f", f);

String s = "Hello world";
message = String.format("%s", s);

// "Hello world, f=0.1"
message = String.format("%s, f=%f", s, f);