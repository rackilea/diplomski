Multipletypeparameters<String, String> g1 = new Multipletypeparameters<>((a, b) -> a + b);
g1.setting("A", "B");
System.out.println(g1.add());

Multipletypeparameters<Integer, Integer> g2 = new Multipletypeparameters<>(
    (a, b) -> a + b
);
g2.setting(10, 10);
System.out.println(g2.add());