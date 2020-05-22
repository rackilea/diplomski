function int sumLengths(List strings) {
    int counter = 0;
    for (Object s : strings)
        counter += ((String) s).length();
    return counter;
}