for (int j = 0; j < row; j++) {
    String s = in.next();
    for (int k = 0; k < column; k++) {
        world[j][k] = Character.getNumericValue(s.charAt(k));
    }
}