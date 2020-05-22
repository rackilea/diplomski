public int selectPerson(float[] probabilies, Random r) {
    float t = r.nextFloat();
    float p = 0.0f;

    for (int i = 0; i < probabilies.length; i++) {
        p += probabilies[i];
        if (t < p) {
            return i;
        }
    }

    // We should not end up here if probabilities are normalized properly (sum up to one)
    return probabilies.length - 1;      
}