import java.util.ArrayList;
import java.util.List;

import java8.util.stream.Collectors;
import java8.util.stream.StreamSupport;

public class FinantialStatement {

    private List<Rubric> values;

    public List<Rubric> getConsolidatedRubrics() {
        List<Rubric> rubrics = StreamSupport.stream(values)
                .sorted((Rubric r1, Rubric r2) -> r1.getOrder().compareTo(r2.getOrder()))
                .collect(Collectors.toCollection(ArrayList::new));
        return rubrics;
    }
}