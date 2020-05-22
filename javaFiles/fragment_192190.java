public class Test {
    public static List<Integer> arrList1;
    public static ArrayList<Integer> arrList2 = new ArrayList<Integer>();

    public static void main (String... args){
        Integer[] toSort = {1, 3, 2, 4, 6, 5};


        arrList1 = Arrays.asList(Arrays.copyOf(toSort, toSort.length));
        insertSort(toSort);

        List<Integer> sortedArray = new ArrayList<Integer>();
        for(int aux: toSort){
            sortedArray.add(aux);
        }

        System.out.println("Array list 1: " + arrList1);
        System.out.println("Array list 2: " + arrList2);
        System.out.println("Sorted array: " + sortedArray);
    }

    public static void insertSort(Integer[] A){
        arrList2.add(arrList1.get(0));
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            if ((j >= 0 && A[j] > value)){
                arrList2.add(A[j]);
            }else{
                arrList2.add(A[i]);
            }
            while(j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                j = j - 1;
            }

            A[j + 1] = value;
        }
    }
}