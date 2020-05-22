import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        // Initialize mankind
        List<Individual> mankind = new ArrayList<>();
        mankind.add(new Individual("A"));
        mankind.add(new Individual("B"));
        mankind.add(new Individual("C"));


        // The stream
        List<Borg> newBorgMembers = mankind.stream().map(individual -> new Borg(individual.id)).collect(Collectors.toList());

        newBorgMembers.forEach(borg -> System.out.println(borg.id));
    }
}

class Individual {
    String id;
    public Individual(String id) {
        this.id = id;
    }


}
class Borg {
    String id;

    public Borg(String id) {
        this.id = id;
    }

}