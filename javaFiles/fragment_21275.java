int divisorsInRange(int min, int max, int div) {
    if (min > max)
        return 0;
    else
        return (min % div == 0 ? 1 : 0) + divisorsInRange(min + 1, max, div);
}