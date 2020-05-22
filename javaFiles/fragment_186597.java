public static int elapsed(Calendar before, Calendar after, int field) {
    Calendar clone = (Calendar) before.clone(); // Otherwise changes are been reflected.
    int elapsed = -1;
    while (!clone.after(after)) {
        clone.add(field, 1);
        elapsed++;
    }
    return elapsed;
}