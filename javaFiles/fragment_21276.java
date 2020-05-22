int countDivisors(int min, int max, int div) {
    int count = (max - min) / div;
    if (min % div == 0 || max % div == 0)
        count++;
    return count;
}