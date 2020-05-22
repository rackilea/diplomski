public static int processData(ArrayList<String> array) {
    String[] str = new String[array.size()];
    array.toArray(str);

    String[][] str1 = new String[str.length][3];

    for(int i=0; i < str.length; i++) {
        String[] parts = str[i].split("\\s+");

        for(int j = 0; j < parts.length || j < 3; j++) {
            str1[i][j] = parts[j];
        }
    }

    // do something next
}