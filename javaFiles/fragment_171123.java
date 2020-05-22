public String decode(String encoded) {
  StringBuilder sb = new StringBuilder();
  for (int i = 0; i < encoded.length(); i++) {
    if (encoded.charAt(i) == '\' && (i + 3) < encoded.length() && encoded.charAt(i + 1) == 'x') {
      sb.append(hexDecode(encoded.substring(i + 2, i + 4)));
      i += 3;
    } else {
      sb.append(encoded.charAt(i));
    }
  }
  return sb.toString;
}