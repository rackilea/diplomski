public static void main(String[] args) {
// TODO Auto-generated method stub
Main main = new Main();
int[] arr1 = new int[]{29, 64, 73, 34, 20};
int[] a = new int[]{2, 2, 2};
//sorted and b would now point to the cloned data of arr1 and a respectively
int[] sorted = insertionSort(arr1.clone());
int[] b = changeValue(a.clone());
main.printq(arr1);
main.printq(sorted);
main.printq(a);
main.printq(b);