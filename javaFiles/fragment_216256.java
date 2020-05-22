import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class NNNTest {

    private static String skillNeed = "Java;C++;C"; //the skills the job need
    private static String skillHave = "SQL:8;Java:9;C++:5;C:9;PHP:5"; //skill and level you have

    public static boolean checkAvailable() { //if all the job needed skills match the skills you have
        return Arrays.stream(skillHave.split(";")).map(s -> s.split(":")[0]).collect(Collectors.toSet()).containsAll(Arrays.asList(skillNeed.split(";")));
    }

    public static void main(String[] args) {
        System.out.println(checkAvailable());
    }
}