public class GenericGroup<T> {

    String type;
    String name;
    ArrayList<T> items;

    public ArrayList<T> getItems(){
        return items;
    }

    public static class SomeGroup extends GenericGroup<SomeItem>{}
    public static class SomeOtherGroup extends GenericGroup<SomeOtherItem>{}

}