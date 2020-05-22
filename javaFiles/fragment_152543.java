import org.paukov.combinatorics.*;
import org.paukov.combinatorics.util.ComplexCombinationGenerator;

public class Main {

    public static void main(String args[]){

        // create a vector (1, 2, 3, 4)
        ICombinatoricsVector<String> vector = Factory.createVector(new String[] { "1", "2", "3", "4" });

        // Create a complex-combination generator
        Generator<ICombinatoricsVector<String>> gen = new ComplexCombinationGenerator<String>(vector, 2);

        // Iterate the combinations
        for (ICombinatoricsVector<ICombinatoricsVector<String>> comb : gen) {
            System.out.println(ComplexCombinationGenerator.convert2String(comb) + " - " + comb);
        }
    }
}