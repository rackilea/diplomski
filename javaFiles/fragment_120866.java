int largestTriangleNumberSmallerThan(int x) {
    int i = 0;
    int last = 0;
    while (true) {
        int triangle = i*(i+1)/2;
        if (triangle > x) return last;
        last = triangle;
        i++;
    }
}