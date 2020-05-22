import java.util.HashSet;
import java.util.Set;

public class Generator<T> {
    Set<T> source;
    Set<Set<T>> combinations;

    public Generator(Set<T> source) {
        this.source = source;
    }

    public static void main(String[] args) {
        final Set<String> source = new HashSet<>();
        for (char character = 'A'; character <= 'Z'; character++){
            source.add(String.valueOf(character));
        }

        final Generator<String> stringGenerator = new Generator<>(source);
        stringGenerator.generate(3);
    }

    public void generate(int size){
        if (size == 0){
            return;
        }
        Set<Set<T>> newCombinations = new HashSet<>();
        for (T element : source) {
            if (combinations == null || combinations.isEmpty()){
                final HashSet<T> set = new HashSet<>();
                set.add(element);
                newCombinations.add(set);
            } else {
                for (Set<T> combination : combinations) {
                    final HashSet<T> newCombination = new HashSet<>(combination);
                    if (newCombination.add(element)) {
                        newCombinations.add(newCombination);
                    }
                }
            }
        }
        combinations = newCombinations;
        generate(size - 1);
    }
}