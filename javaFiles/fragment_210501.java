for (int i = 0; i < word.length(); i++){
    //check the boundaries, if we go out then we didn't find the word;
    if (x < 0 || x >= puzzle.length || y < 0 || y >= puzzle[x].length) return false;

    char c = word.charAt(i);

    //Is not equal
    if (puzzle[x][y] != c) return false;

    x += offsetx;
    y += offsety;
}