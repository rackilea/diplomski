try {
    // Convert from Unicode to UTF-8
    String string = "abc\u5639\u563b";
    byte[] utf8 = string.getBytes("UTF-8");

    // Convert from UTF-8 to Unicode
    string = new String(utf8, "UTF-8");

} catch (UnsupportedEncodingException e) {}