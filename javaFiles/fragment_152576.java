import java.util.Optional;
import java.util.Random;
import java.util.function.BiFunction;

public enum Gender implements BiFunction<Animal, Animal, Optional<Animal>> {
    MALE {
        @Override
        public Optional<Animal> apply(final Animal self,
                                      final Animal other) {
            // example - animal reaches sexual maturity at 2 - you should make this a property of animal
            return self.age > 2 ? other.gender.apply(other, self)
                                : Optional.empty();
        }
    },
    FEMALE {
        @Override
        public Optional<Animal> apply(final Animal self,
                                      final Animal other) {
            final Optional<Animal> child;
            // must be at least 2 to get pregnant, infertile 3 years before death.  Again, just examples
            if (self.age > 2 && self.age < self.lifeExpectancy - 3
                && self.health > 5) {
                final int chance = new Random().nextInt(10);
                child = (chance == 3 || chance == 6 || chance == 9) ? Optional.of(self.reproduce())
                                                                    : Optional.empty();
            } else {
                child = Optional.empty();
            }
            return child;
        }
    };
}