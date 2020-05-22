public String find(final String codon) {
    for (final Abbreviations abb : Abbreviations.values()) {
        if (abb.contains(codon)) {
            return abb.name();
        }
    }

    throw new IllegalArgumentException("Unknown codon: '" + codon + "'");
}