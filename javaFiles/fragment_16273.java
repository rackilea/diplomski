void wrapString(String inputString, int width, Font font){
    String line1;
    String line2;

    if (font.getAdvance(inputString) <= width){
        line1 = inputString;
        line2 = "";
    }
    else{
        int charsInLine1 = countCharsInLine(inputString, 0, inputString.length()-1, width, font);
        int lineBreak = inputString.lastIndexOf(' ', charsInLine1);
        if (lineBreak == -1)
            lineBreak = charsInLine1;
        line1 = inputString.substring(0, lineBreak);

        line2 = inputString.substring(lineBreak+1, inputString.length());
        if (font.getAdvance(line2) > width){
            int charsInLine2 = countCharsInLine(line2, 0, inputString.length()-1, width - font.getAdvance("..."), font);
            line2 = line2.substring(0, charsInLine2) + "...";
        }
    }

    System.out.println("line1: " + line1);
    System.out.println("line2: " + line2);
}

int countCharsInLine(String str, int min, int max, int width, Font font) {

    if (min >= max)
        return max;

    int guess = min + (max - min) / 2;
    int advance = font.getAdvance(str, 0, guess);

    if (advance < width)
        return countCharsInLine(str, guess+1, max, width, font);
    else if (advance > width)
        return countCharsInLine(str, min, guess-1, width, font);
    else
        return guess;
}