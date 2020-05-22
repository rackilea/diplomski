public interface Population<T extends Chromosome>{
    void addChromosomes(List<T> chromosomes);

    List<T> getChromosomes();
}

public class TSPPopulation implements Population<TSPChromosome>
{
    private List<TSPChromosome> chromosomes;

    @Override
    public void addChromosomes(List<TSPChromosome> chromosomes) {
...
    }

    @Override
    public List<TSPChromosome> getChromosomes() {
...    
    }

}