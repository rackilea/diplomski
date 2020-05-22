Person p1 = new Person("Obi-wan", "Kenobi");
Person p2 = new Person("Luke", "Skywalker");
List<Person> jedis = new ArrayList<>();
jedis.add(p1);
jedis.add(p2);
System.out.println(Person.toString(jedis));