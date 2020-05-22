Map<Character, Integer> characters = new HashMap<>();
characters.put('a', 2);
characters.put('b', 2);
characters.put('c', 2);
characters.put('d', 3);
...
characters.put('z', 0);

Integer number = characters.get('a');
System.out.println(number); // Will print '2'