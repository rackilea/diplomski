public class Wrapper<T> {


    public static <T> List<T> getList(T... elements){
        List<T> lst = new ArrayList<>();
        for(T element: elements) {
            lst.add(element);
        }
        return lst;
}