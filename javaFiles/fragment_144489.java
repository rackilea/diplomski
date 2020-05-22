String s = "Doesn't'work or Can''t";

int lengthWithApostrophes = s.length();
int lengthWithoutApostrophes = s.replace("'", "").length();

if(lengthWithApostrophes - lengthWithoutApostrophes >= 2) {
    // Two or more apostrophes
}