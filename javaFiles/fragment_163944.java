public class MyParentObject {
    String something;
    ArrayList<Item> items;
    public ArrayList<Item> getItems() {
       return items;
    }
    // the rest of your getters/setters
}

// the object mapper line becomes:
MyParentObject parentObject = mapper.readValue(new File("path/file.json"), MyParentObject.class);

ArrayList<Item> items = parentObject.getItems();