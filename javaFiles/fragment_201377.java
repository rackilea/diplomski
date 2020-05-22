public class HelloWorld{

     public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
    List<Integer> list2 = Arrays.asList(1, 2);
    boolean test = list1.equals(list2);
    System.out.println("Similar  " + test);
}
}