String row1 = "1234567890";
String row2 = "qwertyuiop";
// and so forth
String[] rows = { row1, row2, .. };
for (int i = 0; i < rows.length; i++) {
    char[] keys = rows[i].toCharArray();
    for (int j = 0; i < keys.length; j++) {
        JButton button = new JButton(Character.toString(keys[j]));
        // add button
    }
}
// add special buttons like space bar