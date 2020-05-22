private char shift(char c) {
    int letter = c-'a';          // calculate distance to 'a'
    letter+= shift;              // add some distance
    letter %=26;                 // handle overflow - if shifted behind 'z'
    return (char) ('a'+ letter); // apply calculated distance to 'a' to get output
                                 // and cast it to type char.
}