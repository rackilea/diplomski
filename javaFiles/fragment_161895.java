public static void main(String[] args) {
  int array[] = new int[]{ 2, 3, 4, 5, 5, 5, 5, 5, 9, 9, 14, 40 };
  int leftIndex = leftSearch(array, 5, 0, array.length-1);
  System.out.println(leftIndex);
  int rightIndex = rightSearch(array, 5, 0, array.length-1);
  System.out.println(rightIndex);
}