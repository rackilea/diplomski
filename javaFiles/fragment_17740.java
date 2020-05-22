String[][] words = new String[2][3];
    words[0][0] = "a";
    words[0][1] = "b";
    words[0][2] = "c";
    words[1][0] = "d";
    words[1][1] = "e";
    words[1][2] = "f";
    for (int row = 0; row < words.length; row++) {
        for (int col = 0; col < words[row].length; col++) {
            System.out.println(words[row][col]);
        }
    }