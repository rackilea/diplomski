int [][] letters = {{'i', 'u'}, {'a', 'g'}, {'e', 'k'}};

for (int i = 0; i < letters.length; i++) {
   for (int j = 0; j < letters[i].length; j++) {
        if (letters[i][j] >= 'a' && letters[i][j] <= 'z') {
            letters[i][j] = (letters[i][j] - 'a');
        } 
    }
}