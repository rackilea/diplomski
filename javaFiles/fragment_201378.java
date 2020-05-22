public class HelloWorld{

     public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
    List<Integer> list2 = Arrays.asList(1, 2);

    Set<Integer> similar2 = new HashSet<Integer>(list2);
    Set<Integer> similar1 = new HashSet<Integer>(list1);
    boolean test = similar1.equals(similar2);
    System.out.println("Similar  " + test);
}
}