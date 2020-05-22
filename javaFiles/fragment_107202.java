int k = (((bytes[0 + j] & 255) - 100) * 100 + (bytes[1 + j] & 255)) - 100;
  String s = k + "-" + toStr(bytes[2 + j])
      + "-" + toStr(bytes[3 + j])
      + " " + toStr(bytes[4 + j] - 1)
      + ":" + toStr(bytes[5 + j] - 1)
      + ":" + toStr(bytes[6 + j] - 1)
      + ".0";