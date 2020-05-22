import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.toMap;

....

Map<String, Double> outMap = 
    myCol.stream()
         .flatMap(m -> m.entrySet().stream())
         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, Double::sum));