for (int i = 0; i < word.length(); i++) {
    String letter = word.substring(i, i + 1);
    if (letter.equals("W")) {
        points+=3;
    }
    else if (letter.equals("D")) {
        points+=1;
    }
}