import java.util.Map;

import org.jpl7.Query;
import org.jpl7.Term;

public class TestQuery {
    public static void main(String argv[]) {
        Query q = new Query("X = 1");
        Map<String, Term>[] solutions = q.allSolutions();
        System.out.println(solutions[0]);
    }
}