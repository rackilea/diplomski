import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

class Filter {

    public static Predicate<String> nameStartingWithPrefix(String nextLine) {
        return new Predicate<String>() {

            @Override
            public boolean test(String t) {
                // System.out.println(t);
                return t.startsWith(nextLine);
            }
        };
    }

}


public class Solution1 {
    private static final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "aaryanna",
                "aayanna",
                "airianna",
                "alassandra",
                "allanna",
                "allannah",
                "allessandra",
                "allianna",
                "allyanna",
                "anastaisa",
                "anastashia",
                "anastasia",
                "annabella",
                "annabelle",
                "annebelle"
                );

        names.stream().filter(Filter.nameStartingWithPrefix(scanner.nextLine()))
        .map(Mapper.getDistinctCharactersCount()).forEachOrdered(System.out::println);
    }
}