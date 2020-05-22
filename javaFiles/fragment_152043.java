source
.buffer(31)
.map(bits -> {
    int result = 0;
    for (int b : bits) {
        result = (result << 1) | (b ? 1 : 0);
    }
    return result;
})