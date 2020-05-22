public static void main(String[] args) {
    transcode();
    System.setProperty("ibm.swapLF", "true");
    transcode();
  }

  private static void transcode() {
    byte EBCDIC_NL = 0x15; //next line
    byte EBCDIC_LF = 0x25; //line feed
    byte EBCDIC_CR = 0x0D; //carriage return

    ebcdicToUtf16(EBCDIC_NL);
    ebcdicToUtf16(EBCDIC_LF);
    ebcdicToUtf16(EBCDIC_CR);

    utf16ToEbcdic("\u0085"); //next line
    utf16ToEbcdic("\n"); //line feed
    utf16ToEbcdic("\r"); //carriage return
  }

  private static void ebcdicToUtf16(byte... b) {
    String utf16 = new String(b, Charset.forName("IBM500"));
    System.out.format("%02x -> %04x%n", b[0] & 0xFF, utf16.charAt(0) & 0xFFFF);
  }

  private static void utf16ToEbcdic(String s) {
    byte[] b = s.getBytes(Charset.forName("IBM500"));
    System.out.format("%04x -> %02x%n", s.charAt(0) & 0xFFFF, b[0] & 0xFF);
  }