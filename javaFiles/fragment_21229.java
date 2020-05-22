import java.util.Random;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

public class Test {

    // validator method
    @EnsuresNonNullIf(expression="#1", result=true)
    static boolean hasText(@Nullable String s) {
        return !(s == null || s.trim().isEmpty());
    }

    public static void main(String[] args) {
        // s could come from anywhere and is null iff the data does not exist
        String s = (new Random().nextBoolean()) ? "valid" : null;
        if (hasText(s)) {
            // Potential null pointer access: The variable s may be null at this location
            System.out.println(s.length());
            // ... do actual stuff ...
        }
    }
}