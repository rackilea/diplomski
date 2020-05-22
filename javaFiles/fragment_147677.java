if (prevFollEqual){
    if (length == 1) return 3;
    else return 3 * calcSequenceSubs(length-1, false);
} else {
    if (length == 1) return 2;
    else return 2 * calcSequenceSubs(length-1, false) + calcSequenceSubs(length-1, true);
}