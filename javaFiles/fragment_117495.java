public class Gene {
    ...
    public Gene(Gene other) {
        this.gene = Arrays.copyOf(other.gene, other.gene.length);
    }
}