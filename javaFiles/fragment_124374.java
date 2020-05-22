ByteArrayInputStream msg = ...
int c;
String s;
while ((c = msg.read())!= -1) {
  char x = (char) c;
  if (x=='1' || x=='0') break;
  s += x;
}