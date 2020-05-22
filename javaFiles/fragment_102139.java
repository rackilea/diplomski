class MaybeReader {
  BufferType buff;
  int dsLen;
  boolean failed = false;

  // Add a constructor to populate buff and dsLen appropriately.

  boolean failed(long obj) {
    return failed;
  }

  int maybeReadInt(int defaultValue) {
    if (dsLen >= 4) {
      dsLen -= 4;
      return buff.readInt();
    } else {
      failed = true;
      return defaultValue;
    }
  }

  short maybeReadShort(short defaultValue) {
    if (dsLen >= 2) {
      dsLen -= 2;
      return buff.readShort();
    } else {
      failed = true;
      return defaultValue;
    }
  }
}