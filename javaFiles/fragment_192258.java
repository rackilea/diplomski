String [][] letters = {{"i", "u"}, {"a", "g"}, {"e", "k"}};

for (int i = 0; i < letters.length; i++) {
    for (int j = 0; j < letters[i].length; j++) {
        if (letters[i][j].charAt(0) >= 'a' && letters[i][j].charAt(0) <= 'z') {
           letters[i][j] = Integer.toString((letters[i][j].charAt(0) - 'a');
        } 
    }
}