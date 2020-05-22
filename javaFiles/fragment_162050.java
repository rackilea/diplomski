abstract class Population<T extends Player>
{
    T[] members;

    void mixUpPopulation() {...}
    Strategy[] getMeanStrategies() {...}
    double getMeanFitness() {...}
    ...
}

class SignallerPopulation extends Population<Signaller>
{
    public SignallerPopulation(int popSize) { members = new Signaller[popSize]; }
    ...
}

class ReceiverPopulation extends Population<Receiver>
{
    public ReceiverPopulation(int popSize) { members = new Receiver[popSize]; }
    double[] getChannelPreferences() {...}
    ...
}