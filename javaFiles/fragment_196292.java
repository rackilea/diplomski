// Use interfaces rather than base classes. Prefer Composition over Inheritance.
public interface IGeneticAlgorithm { ... }
public interface IIndividual { ... }
public interface IIndividualFactory {
    public IIndividual getInstance();
}

// Implementations
public class FastGeneticAlgorithm implements IGeneticAlgorithm {
    private IIndividualFactory individualFactory;

    // Use constructor injection to declare the implementation's dependencies
    public FastGeneticAlgorithm(IIndividualFactory individualFactory) {
        this.individualFactory = individualFactory;
    }
}

public class SmallIndividual implements IIndividual { }
public class SmallIndividualFactory implements IIndividualFactory {
    public IIndividual getInstance() {
        return new SmallIndividual();
    }
}

public static class Program {
    public static void main(String[] args){
        AbstractGeneticAlgorithm algoritm = CreateAlgorithm();
        algoritm.makeIndividual();
    }

    private AbstractGeneticAlgorithm CreateAlgorithm() {
        // Build complete object graph inside the Composition Root
        return new FastGeneticAlgorithm(new SmallIndividualFactory());
    }
}