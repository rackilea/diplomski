public class ArrayEquality {
    public static void main(String[] args) {
        String[] array1 = {"test1","test2"};
        String[] array2 = {"test2","test1"};
        String[] array3 = {"test2","test3"};

        String[] strList1 = {"ABC", "CDE", "EFG"};
        String[] strList2 = {"ABC", "EFG", "CDE"};

        System.out.println(arrayEquals(array1,array2));
        System.out.println(arrayEquals(array2,array3));

        System.out.println(arrayEquals(strList1,strList2));
    }

    //ARRAY EQUALITY CHECK
    private static boolean arrayEquals(String[] array1, String[] array2) {
        List<String> list1 = Arrays.asList(array1);
        List<String> list2 = Arrays.asList(array2);

        return list1.containsAll(list2) && list2.containsAll(list1);
    }
}