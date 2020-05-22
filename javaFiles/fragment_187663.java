import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

...

Map<Long, Long> map = 
    employees.stream()
             .collect(collectingAndThen(groupingBy(Employee::getDeptId, counting()), 
                                        m -> { m.values().removeIf(v -> v <= 1L); return m; }));