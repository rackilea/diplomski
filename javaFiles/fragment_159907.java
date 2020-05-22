OneTimePrinter printer1 = new OneTimePrinter();
Stream.of("Five","Six", "Seven", "Eight")
.peek((e) -> printer1.print("TEST OUTPUT:\n------------"))
.map(e -> "Number " + e)
.forEach(System.out::println);  

OneTimePrinter printer2 = new OneTimePrinter();
Stream.of()
.peek((e) -> printer2.print("TEST OUTPUT:\n------------"))
.map(e -> "Number " + e)
.forEach(System.out::println);