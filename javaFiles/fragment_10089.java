public static Operation fromValue(byte value) {
  switch (value) {
  case 0:  return Operation.a;
  case 1:  return Operation.b;
  default: throw new IllegalArgumentException();
  }
}