IntSupplier generator = new IntSupplier() {
    int current = 0;

    public int getAsInt() {
        return current++;
    }
};

IntStream natural = IntStream.generate(generator);