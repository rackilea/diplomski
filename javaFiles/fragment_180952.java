public enum Abbreviations {
    Ala("GCU", "GCC", "GCA", "GCG"),
    Arg("CGU", "CGC", "CGA", "CGG", "AGA", "AGG")
    // ...
    ;

    private final List<String> codons;

    private Abbreviations(final String... codons) {
        this.codons = Arrays.asList(codons);
    }


    public boolean contains(final String codon) {
        return this.codons.contains(codon);
    }
}