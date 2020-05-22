@Override
public double read() throws BufferUnderflowException {
  long value = 0;
  int exp = 0;
  boolean negative = false;
  int decimalPlaces = Integer.MIN_VALUE;
  while (true) {
    byte ch = buffer.get();
    if (ch >= '0' && ch <= '9') {
      while (value >= MAX_VALUE_DIVIDE_10) {
        value >>>= 1;
        exp++;
      }
      value = value * 10 + (ch - '0');
      decimalPlaces++;
    } else if (ch == '-') {
      negative = true;
    } else if (ch == '.') {
      decimalPlaces = 0;
    } else {
      break;
    }
  }

  return asDouble(value, exp, negative, decimalPlaces);
}