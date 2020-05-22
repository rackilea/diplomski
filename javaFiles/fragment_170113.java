// It would probably be a better idea to use HH:mm:ss.SSS, and the nanoseconds.
// Not to imply that that's a good idea, just better then this (but would add even more digits).
private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
// This isn't really nanosecond accurate, and is probably a bad idea.
private static String getNanoTime() {
  long start = System.nanoTime();
  StringBuilder sb = new StringBuilder();
  Calendar c = Calendar.getInstance();
  sb.append(sdf.format(c.getTime()));
  sb.append(".");
  sb.append(System.nanoTime() - start);
  return sb.toString();
}

public static void main(String[] args) {
  System.out.println(getNanoTime());
}