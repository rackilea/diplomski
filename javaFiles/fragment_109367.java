for (int i = 0; i < 32; i++) {
    for (int j = 0; j < 32; j++) {

        coords = new Coords(i, j);
        int[] someData = new int[4];   // <==== create a new array for each Map value
        // Every Coord gets a few random numbers
        for (int k = 0; k < 4; k++) {
            someData[k] = random.nextInt(8564);
        }

        map.put(coords, someData);

    }