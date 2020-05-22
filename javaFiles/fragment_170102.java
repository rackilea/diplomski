public class BookData {
    String kind;
    Integer totalItems;
    List<Item> items;
}

public class Item {
    String kind;
    String id;
    //...
    Volume volumeInfo;
}