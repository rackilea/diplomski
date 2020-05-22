for (int i = 0; i <= 0xFF; i++) {
    StringBuilder builder = new StringBuilder("00000000");
    String binary = Integer.toBinaryString(i);
    builder.replace(8 - binary.length(), 8, binary);
    System.out.println(builder);
}