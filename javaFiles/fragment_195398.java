public static char[][] fillArray(char[][] a) {
    int counter = 0;

    for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a[i].length; j++) {
            if(counter >= 26)
                counter = 0;
            a[i][j] = letters.charAt(counter);
            counter++;
        }
    }

    return a;
}