ArrayList<Character> temp = ...

    String string=temp.stream().map(c->c.toString()).collect(Collectors.joining(""));

    char[] charArray=string.toCharArray();

    System.out.println(charArray);