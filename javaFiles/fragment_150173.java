String s7 = null;
try {
    .....
    s7 = ftpfile1.getName().toString();
    .....
} catch (Exception e) {
    if (s7 != null) {
      System.out.println(s7);
    } else {
      // s7 is null ...
    }
}