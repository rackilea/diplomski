public class Item {
    private final long timestamp;
    private final String bookType;

    // Constructors, getters etc
}

// ...

public int getSizeOfBookTypeByMinTimestamp() {
    return items.stream()
        .collect(Collectors.groupingBy(Item::getBookType))
        .get(getMin(items))
        .size();
}

private String getMin(List<Item> items) {
    return items
        .stream()
        .min(Comparator.comparingLong(Item::getTimestamp))
        .orElse( /* HANDLE NO OBJECT */ ) // you can use also orElseThrow etc
        .getBookType();
}