public static void printInOrder(ArrayList<Integer> data){

    Integer[] array = (Integer[]) data.toArray();
    Arrays.sort(array);
    System.out.println(array[0]);

}