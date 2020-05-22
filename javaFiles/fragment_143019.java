public class ListExample {
    static List<Integer> myList;
    static {
        myList= Arrays.asList(1, 2, 3, 4, 5);

        // this would work too
        // myList = new ArrayList<>();
        // for (int i = 1; i < 6; i++) {
        //     myList.add(i);
        // }
    }
    public static void main(String[] args) {
        System.out.println(myList);         // [1, 2, 3, 4, 5]
    }
}