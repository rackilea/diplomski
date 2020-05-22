import static java.util.stream.Collectors.*;
import static java.util.function.Function.identity;

Map<Job, Optional<Job>> collect = jobs.stream()
    .collect(groupingBy(identity(), reducing((l, r) -> {
        l.networks().addAll(r.networks());
        return l;
    })));