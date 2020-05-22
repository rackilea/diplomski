public class MyArrayList{
public static void main(String[] args) {
    Float a = new Float(1.1);
    ArrayList<Float> obj = new ArrayList<Float>();
    obj.add(a);
    function1(obj);
    for (Object obj2 : obj) {
        System.out.println(obj2);
    }
}
private static void function1(ArrayList list) {
    Integer b = new Integer(1);
    list.add(b);
}