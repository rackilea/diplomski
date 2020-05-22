for (int i = 0; i < n; i++) {
    StringTokenizer line = new StringTokenizer(read line here);
    for (int j = 0; j < m; j++) {
        String next = line.nextToken(); //next pair
        String[] values = next.split(","); //split pair by comma
        array1[n][m] = Integer.parseInt(values[0]);
        if (values.length == 2) { //in case there is no comma
            array2[n][m] = Integer.parseInt(values[1]);
        }
    }
}