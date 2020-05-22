// Standard Java 5+ foreach-loop that prints the values
for (Car c : hm.values()) {
    System.out.println(c);
}

// Loop using an iterator that prints the keys
for (Iterator<Car> itr = hm.keys().iterator(); itr.hasNext(); ) {
    System.out.println(itr.next());
}

// Or a Java 8 loop
hm.values().forEach(System.out::println);