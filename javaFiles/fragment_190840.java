void expandCapacity(int minimumCapacity) {
    int newCapacity = (value.length + 1) * 2; //important part here
    if (newCapacity < 0) {
        newCapacity = Integer.MAX_VALUE;
    } else if (minimumCapacity > newCapacity) {
        newCapacity = minimumCapacity;
    }
    value = Arrays.copyOf(value, newCapacity);
}