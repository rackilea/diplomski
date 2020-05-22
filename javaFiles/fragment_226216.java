public class Box<T> {

    private List<T> items;

    public Box(){
        items = new ArrayList<>();
    }

    public <T2> void addItemToBox(T2 t){
        items.add(t);
    }
}