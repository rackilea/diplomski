if (length != 0) {
    while ((k < length) && solids[k] != null && foo.greaterThan(solids[k], m))
        ++k;
    if(solids[k] == null) {
        return;
    }
    for (int j = length; j > k; --j)
        solids[j] = solids[j - 1];
}