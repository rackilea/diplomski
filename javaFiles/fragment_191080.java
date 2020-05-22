String line = "ABCDEFGHIJKLMNOPQRSTUVWXYZOOOOOOO";

    char[][] table = new char[6][5];
    int counter = 0;
    // fill array
    for(int i = 0; i < 6; i++) {
        for(int j = 0; j < 5; j++) {
            table[i][j] = line.charAt(counter++);  // need to increment through the String
        }
    }

    // print array
    for(int i = 0; i < 6; i++) {
        for(int j = 0; j < 5; j++) {
            System.out.print(table[i][j] + " ");  // not println
        }
        System.out.println();
    }