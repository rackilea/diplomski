import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App6 {
    public static final String ADDED = "ADDED";
    public static final String DELETED = "DELETED";
    public static final String MODIFIED = "MODIFIED";
    public static final String NOT_MODIFIED = "NOT_MODIFIED";

    public static void main(String[] args) {
        List<A> originalObjectList = Arrays.asList(new A("a"), new A(""), new A("a"), new A("a"));
        List<A> modifiedObjectList = Arrays.asList(new A("a"), new A("b"), new A("b"), new A(""));

        List<Result> results = IntStream
                .range(0, originalObjectList.size())
                .mapToObj(i -> {
                    A original = originalObjectList.get(i);
                    A modified = modifiedObjectList.get(i);
                    return compare(original, modified);
                })
                .collect(Collectors.toList());
        System.out.println(results);
    }

    public static Result compare(A or, A mod) {
        if (or == null || mod == null) {
            throw new IllegalArgumentException("Comparable objects should not be null");
        }
        if (or.field == null || mod.field == null) {
            throw new IllegalArgumentException("Comparable fields of objects should not be null");
        }
        if (or.field.equals(mod.field)) {
            return new Result(NOT_MODIFIED, or.field);
        } else if (or.field.isEmpty() && !mod.field.isEmpty()) {
            return new Result(ADDED, mod.field);
        } else if (!or.field.isEmpty() && mod.field.isEmpty()) {
            return new Result(DELETED, or.field);
        } else {
            return new Result(MODIFIED, mod.field);
        }
    }
}

class A {
    String field;

    public A(String field) {
        this.field = field;
    }
}

class Result {
    String status;
    String value;

    public Result(String status, String value) {
        this.status = status;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status='" + status + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}