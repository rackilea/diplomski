long count = count(s1, t1, (a, b) -> a.compareTo(b) < 0);
count += count(t1, s1, (a, b) -> b.compareTo(a) < 0);   

public static long count(String s, String t, BiFunction<String, String, Boolean> comp) {

      return IntStream.range(0, s.length()).filter(
        i -> Character.isDigit(s.charAt(i))).mapToObj(
              i -> s.substring(0, i) + s.substring(i + 1)).filter(
                    ss -> comp.apply(ss, t)).count();
}