public int hashcode_shared() {
    if (hash == 0) { hash = 1; }
    return hash;
}

public int hashcode_local() {
    int h = hash;
    if (h == 0) { hash = h = 1; }
    return h;
}