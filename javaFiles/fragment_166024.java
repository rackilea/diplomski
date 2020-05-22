import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveNullValue {
    public static void main( String args[] ) {
        String[] firstArray = {"test1", "", "test2", "test4", "", null};

        firstArray = Arrays.stream(firstArray)
                     .filter(s -> (s != null && s.length() > 0))
                     .toArray(String[]::new);    

    }
}