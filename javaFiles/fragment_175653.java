Random random = new Random();

    int oneDigit = random.nextInt( 10 );
    int twoDigit = 10 + random.nextInt( 90 );
    int threeDigit = 100 + random.nextInt( 900 );
    int fourDigit = 1000 + random.nextInt( 9000 );

    System.out.println( String.format(
            "oneDigit: %d, twoDigit: %d, threeDigit: %d, fourDigit: %d",
            oneDigit,
            twoDigit,
            threeDigit,
            fourDigit ) );