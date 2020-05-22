Set<Character> characters1 = new TreeSet<Character>();
    for(int i = 0; i < num1.length(); i++) {
        characters1.add(num1.charAt(i));
    }

    Set<Character> characters2 = new TreeSet<Character>();
    for(int i = 0; i < num2.length(); i++) {
        characters2.add(num2.charAt(i));
    }

    characters1.retainAll(characters2);
    return characters1.size();