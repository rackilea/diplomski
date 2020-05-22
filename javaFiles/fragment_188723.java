while (sets[k] >= 0) {
    // save old parent to variable
    int next = sets[k];

    sets[k] = root;
    k = next;
}