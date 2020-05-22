public abstract class Genome<T extends Genome<T>> {
    abstract public T randomize();
    abstract public T mutate();
    abstract public T crossOver(T genome);
}

public class GenomeSubclass extends Genome<GenomeSubclass>
{
    public GenomeSubclass randomize();
    // etc...
}