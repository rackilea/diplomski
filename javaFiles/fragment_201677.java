Hashtable<Integer, String> Deck = new Hashtable();

    for (int i = 0; i < 10; i++) {
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        int key = (int) (Math.random() *52) ;
        Deck.put(key, generatedString);
    }
    System.out.println(Deck);