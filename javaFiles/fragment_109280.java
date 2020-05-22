@POST
public List<Map<String, String>> search() {   

    List<Map<String, String>> list = new ArrayList<>();
    Map<String, String> item;

    item = new HashMap<>();
    item.put("Name", "John");
    item.put("Age", "69");
    list.add(item);

    item = new HashMap<>();
    item.put("Jane", "John");
    item.put("Age", "96");
    list.add(item);

    return list;
}