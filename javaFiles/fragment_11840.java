import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

...

List<Item> list = ....
Map<Group, Map<String, List<Integer>>> map =
    list.stream().collect(groupingBy(i -> new Group(i.getField1(), i.getField2()),
                                     groupingBy(Item::getField3, mapping(Item::getField4, toList()))));