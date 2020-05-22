if (result.e < -1024) {
    result.zero = true;
    return result;
} else if (result.e > 1024) {
    result.infinity = true;
    return result;
}