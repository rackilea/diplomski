if(process.getClass().getName().equals("java.lang.UNIXProcess")) {
  /* get the PID on unix/linux systems */
  try {
    Field f = process.getClass().getDeclaredField("pid");
    f.setAccessible(true);
    pid = f.getInt(p);
  } catch (Throwable e) {
  }
}