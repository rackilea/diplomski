Stream<Character> sch = "abc".chars().mapToObj(i -> (char)i);
sch.forEach(ch -> System.out.printf("%c %s%n", ch, ch.getClass().getName()));

a java.lang.Character
b java.lang.Character
c java.lang.Character