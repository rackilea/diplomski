public class BasicPipelinePattern {
    List<Filter> filters;

    public Object process(Object input) {
        for (Filter c : filters) {
            try {
                input = c.apply(input);
            } catch (Exception e) {
                // exception handling
            }
        }
        return input;
    }

}

public interface Filter {
    public Object apply(Object o);
}