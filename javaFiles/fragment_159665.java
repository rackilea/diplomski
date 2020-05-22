MyList<Integer> number = new MyList<>();

number.add(1);
number.add(2);
number.add(3);

number.map(v -> "#" + v).forEach(System.out::println);