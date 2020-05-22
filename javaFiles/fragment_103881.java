public class Test {
  static Pattern regex = Pattern.compile("(..)(..)(..)(..)(..)(..)");
  public static void main(String[] args) {
    final List<String> inMacs = new ArrayList<>(), outMacs = new ArrayList<>();
    for (int i = 0; i < 80_000; i++) inMacs.add(mac());
    final long start = System.nanoTime();
    for (String mac : inMacs) {
      final Matcher m = regex.matcher(mac);
      m.matches();
      outMacs.add(String.format("%s:%s:%s:%s:%s:%s",
          m.group(1), m.group(2), m.group(3), m.group(4), m.group(5), m.group(6)));
    }
    System.out.println("Took " + (System.nanoTime() - start)/1_000_000 + " milliseconds");
    final Iterator<String> it = outMacs.iterator();
    for (int i = 0; i < 100; i++) System.out.println(it.next());
  }

  static Random rnd = new Random();
  static String mac() {
    final long mac = (long) (rnd.nextDouble()*(1L<<48));
    return String.format("%012x", mac).toUpperCase();
  }
}