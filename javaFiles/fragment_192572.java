Stream<User> byId = Stream.of(new User(12), new User(10))
            .sorted(Comparator.comparing(User::getId));

System.out.println(byId.spliterator().hasCharacteristics(Spliterator.SORTED));

Stream<User> natural = Stream.of(new User(12), new User(10))
            .sorted(Comparator.naturalOrder());

System.out.println(natural.spliterator().hasCharacteristics(Spliterator.SORTED)); 

Stream<User> plain = Stream.of(new User(12), new User(10)).sorted();
System.out.println(plain.spliterator().hasCharacteristics(Spliterator.SORTED));