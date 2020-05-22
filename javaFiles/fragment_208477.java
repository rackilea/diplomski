static int[] generate(int n) {
    return new Random().ints(102, 988).filter(i -> {
                int d1 = i / 100, d2 = i / 10 % 10, d3 = i % 10;
                return (d1 != d2 && d1 != d3 && d2 != d3);
            }).limit(n).toArray();
}