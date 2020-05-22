public abstract class Farm {
    Animal abstract getAnimal();
}

public class Abattoir extends Farm {
    @Override
    Pig getAnimal() { ... }
}