char[][] ch = new char[3][];
ch[0] = new char[]{'a', 'b', 'c'};
ch[1] = new char[]{'d', 'e', 'f'};
ch[2] = new char[]{'g', 'h', 'i'};

String[] s = Stream.of(ch)
       .map(String::new)
       .toArray(String[]::new);