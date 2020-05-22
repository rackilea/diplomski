private static int indexOf(String source, String target) {
    if (target.length() > source.length()) {
        return -1;
    }

    Collator collator = Collator.getInstance();
    collator.setStrength(Collator.PRIMARY);

    int end = source.length() - target.length() + 1;

    for (int i = 0; i < end; i++) {
        String sourceSubstring = source.substring(i, i + target.length());

        if (collator.compare(sourceSubstring, target) == 0) {
            return i;
        }
    }

    return -1;
}