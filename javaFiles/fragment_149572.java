import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toList;

...

List<A> resultList =
        list.stream()
            .collect(groupingBy(A::getGroupName, 
                                maxBy(comparingInt(A::getValue))))
            .values()
            .stream()
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(toList());