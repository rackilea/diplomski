import java.util.function.*;
import static java.util.Map.entry;

private static final Map<String,Supplier<Animal>> factoryMap = Map.of(
    "Meow", Cat::new, // Alternatively: () -> new Cat()
    "Woof", Dog::new // Note: No extra comma like arrays.
);

// For more than 10, use Map.ofEntries and Map.entry.
private static final Map<String,Supplier<Animal>> factoryMap2 = Map.ofEntries(
    entry("Meow", Cat::new),
    ...
    entry("Woof", Dog::new) // Note: No extra comma.
);

public Animal createAnimal(String action) {
    Supplier<Animal> factory = factoryMap.get(action);
    if (factory == null) {
        throw EhException();
    }
    return factory.get();
}