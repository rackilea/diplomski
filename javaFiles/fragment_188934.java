if(letter.indexOf(word.charAt(i)) != -1) { // The same as assignment of charLocation
    check = false;
} else {
    // charLocation will always be -1 here.
    int charLocation = letter.indexOf(word.charAt(i));
    // Causing the first substring to be out of range.
    letter = letter.substring(0,charLocation)+letter.substring(charLocation+1,letter.length());
 }