String[] words = { "2012010", "2012012", "2012011", "201201A" };
    Arrays.sort(words, STANDARD_ALPHABETICAL_ORDER);
    System.out.println("In lexicographical order:");
    for (int i = 0; i < 4; i++) {
        System.out.println(words[i]);
    }