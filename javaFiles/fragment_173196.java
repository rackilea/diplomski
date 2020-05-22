import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class TestEnumSet {
    public static void main(String[] args) {
        System.out.println("Started\n");

        EnumSet<Cars> set = EnumSet.of(Cars.Toyata, Cars.Audi, Cars.Honda, Cars.BMW);

        List<Cars> list = Arrays.asList(set.toArray(new Cars[]{}));
        list.sort((a, b) -> a.toString().compareTo(b.toString()));

        list.stream().forEach(a -> System.out.println(a.id + " : " + a.toString()));

        System.out.println("\nFnished");
    }

    public static enum Cars {
        Toyata(1), Audi(2), Honda(3), BMW(4);

        int id;
        Cars(int id ) {
            this.id = id;
        }
    }
}